package com.mhqy.cloud.desktop.service.internet.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.domin.CDMusician;
import com.mhqy.cloud.desktop.domin.CDNews;
import com.mhqy.cloud.desktop.domin.CDSong;
import com.mhqy.cloud.desktop.domin.WeatherDomin.CDWeather;
import com.mhqy.cloud.desktop.service.internet.InternetService;
import com.mhqy.cloud.desktop.service.internet.ReptileService;
import com.mhqy.cloud.desktop.service.song.CDMusicianService;
import com.mhqy.cloud.desktop.service.song.CDSongService;
import com.mhqy.cloud.desktop.service.weather.WeatherService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/5/23
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service
public class ReptileServiceImpl implements ReptileService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ReptileServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private InternetService internetService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private CDMusicianService cdMusicianService;

    @Autowired
    private CDSongService cdSongService;

    @Value("${redis.key.news}")
    private String REDIS_KEY_NEWS;

    @Value("${redis.key.weather}")
    private String REDIS_KEY_WEATHER;

    @Value("${redis.key.column}")
    private String REDIS_KEY_COLUMN;

    /**
     * @Description:获取热点信息
     * @author: peiqiankun
     * @date: 2018/5/23 10:15
     * @mail: peiqiankun@jd.com
     */
    @Override
    public void getHotNews() throws Exception {
        LOGGER.info("新闻任务开始执行");
        String path = "http://v.juhe.cn/toutiao/index?type=top&key=270bcc91e2a8ef430f74e8319e6af774";
        JsonObject jsonObject = getJsonByUrl(path);
        JsonObject result = (JsonObject) jsonObject.get("result");
        List<CDNews> cdNews = (List) BeanJsonUtil.json2Object(result.get("data").toString(), List.class);
        LOGGER.info("新闻存入redis信息：key:{},value:{}", REDIS_KEY_NEWS, cdNews);
        redisTemplate.opsForValue().set(REDIS_KEY_NEWS, BeanJsonUtil.bean2Json(cdNews));
        LOGGER.info("新闻数据爬取成功");
    }

    /**
     * @Description:获取壁纸信息
     * @author: peiqiankun
     * @date: 2018/5/23 10:15
     * @mail: peiqiankun@jd.com
     */
    @Override
    public void getWallpaper() throws Exception {
        LOGGER.info("壁纸任务开始执行");
        List<Map<String, String>> column = new ArrayList<>();
        Document document = internetService.getDocByUrl("http://www.5857.com/list-9-0--0-0-0-1.html");
        Elements elements = document.getElementsByClass("first");
        for (Element element : elements) {
            Elements ahrefs = element.getElementsByTag("a");
            for (Element ahref : ahrefs) {
                Map<String, String> map = new HashMap<>();
                map.put("href", ahref.attr("href"));
                map.put("title", ahref.text());
                column.add(map);
            }
        }
        redisTemplate.opsForValue().set(REDIS_KEY_COLUMN, BeanJsonUtil.bean2Json(column));
        if (!column.isEmpty()) {
            for (Map<String, String> map : column) {
                LOGGER.info("爬取壁纸数据href:{}", map.get("href"));
                List<Map<String, String>> photoList = new ArrayList<>();
                Document doc = internetService.getDocByUrl(map.get("href"));
                Elements docElementsByClass = doc.getElementsByClass("piclist");
                for (Element element : docElementsByClass) {
                    Elements elementsByTags = element.getElementsByClass("listbox");
                    for (Element tag : elementsByTags) {
                        doc = internetService.getDocByUrl(tag.select("a").attr("href"));
                        Elements photoElements = doc.getElementsByClass("photo-a");
                        for (Element photo : photoElements) {
                            Map<String, String> photoMap = new HashMap<>();
                            photoMap.put("src", photo.select("img").attr("src"));
                            photoMap.put("title", photo.select("img").attr("alt"));
                            photoList.add(photoMap);
                        }
                    }
                }
                redisTemplate.opsForValue().set(map.get("href"), BeanJsonUtil.bean2Json(photoList));
                Thread.sleep(3000);
            }
        }
        LOGGER.info("壁纸数据爬取成功");
    }

    /**
     * @Description:获取天气信息
     * @author: peiqiankun
     * @date: 2018/5/23 10:15
     * @mail: peiqiankun@jd.com
     */
    @Override
    public void getWeather() throws Exception {
        LOGGER.info("天气任务开始执行");
        //获取新闻top doc
        Document document = internetService.getDocByUrl("http://www.weather.com.cn/textFC/hb.shtml");
        //获取各省的url
        List<String> list = weatherService.getProvinceUrl(document);
        //各省的doc ist
        List<Document> documentList = new ArrayList<>();
        for (String provinceUrl : list) {
            documentList.add(internetService.getDocByUrl(provinceUrl));
        }
        //各市的url
        List<String> cityUrl = new ArrayList<>();
        for (Document cityDoc : documentList) {
            List<String> cityPartUrl = weatherService.getCity(cityDoc);
            for (String url : cityPartUrl) {
                cityUrl.add(url);
            }
        }
        for (String url : cityUrl) {
            Document doc = internetService.getDocByUrl(url);
            //天气结果
            CDWeather cdWeather = weatherService.getWeather(doc);
            LOGGER.info("开始存入redis天气信息 key:{},value:{}", cdWeather.getAddressId(), BeanJsonUtil.bean2Json(cdWeather));
            redisTemplate.opsForValue().set(cdWeather.getAddressId(), BeanJsonUtil.bean2Json(cdWeather));
            Thread.sleep(3000);
        }
        redisTemplate.opsForValue().set(REDIS_KEY_WEATHER, "true");
        LOGGER.info("天气数据爬取成功");
    }

    /**
     * @Description:爬虫百度音乐
     * @author: peiqiankun
     * @date: 2018/6/9 17:51
     * @mail: peiqiankun@jd.com
     */
    @Override
    public void getBaiduMusician() throws Exception {
        cdMusicianService.deleteAllData();
        String href = null, title = null;
        String arr[] = null;
        LOGGER.info("爬虫百度音乐人开始执行");
        Document document = internetService.getDocByUrl("http://music.baidu.com/artist");
        Elements elements = document.getElementsByClass("container");
        Element element = elements.get(0);
        //所有a链接
        Elements aelement = element.getElementsByTag("a");
        CDMusician cdMusician = new CDMusician();
        for (Element ele : aelement) {
            href = ele.attr("href");
            title = ele.attr("title");
            if (!StringUtils.isEmpty(href) && !StringUtils.isEmpty(title) && href.contains("artist")) {
                cdMusician.setMusicianName(title);
                arr = href.split("/");
                cdMusician.setMusicianBdId(Long.parseLong(arr[2]));
                LOGGER.info("插入数据库音乐人数据：{}", BeanJsonUtil.bean2Json(cdMusician));
                cdMusicianService.insertSelective(cdMusician);
            }
        }
    }

    /**
     * @Description:根据url获取json信息
     * @author: peiqiankun
     * @date: 2018/6/12 11:17
     * @mail: peiqiankun@jd.com
     */
    @Override
    public JsonObject getJsonByUrl(String url) throws Exception {
        URL url1 = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
        printWriter.flush();
        BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len;
        byte[] arr = new byte[1024];
        while ((len = bis.read(arr)) != -1) {
            bos.write(arr, 0, len);
            bos.flush();
        }
        bos.close();
        JsonParser parse = new JsonParser();
        return (JsonObject) parse.parse(bos.toString("utf-8"));
    }

    /**
     * @Description:百度音乐爬虫
     * @author: peiqiankun
     * @date: 2018/6/12 15:48
     * @mail: peiqiankun@jd.com
     */
    @Override
    public void getMusicianInfoAndMuisc() throws Exception {
        //百度歌手信息
        String musicianUrl = "http://music.baidu.com/artist/";
        //歌曲信息
        String musicInfoUrl = "http://music.baidu.com/data/music/fmlink?type=mp3&songIds=";
        LOGGER.info("从百度音乐查询歌手所属歌曲");
        CDSong cdSong = new CDSong();
        String arr[] = null;
        Map<String, String> musicInfo = null;
        JsonObject jsonObject = null;
        Element element1, element2, element3;
        try {
            List<CDMusician> cDMusicianList = cdMusicianService.selectAllData();
            for (CDMusician cdMusician : cDMusicianList) {
                LOGGER.info("查询音乐家的详细信息：音乐家Id{},音乐家名称：{}", cdMusician.getMusicianBdId(), cdMusician.getMusicianName());
                //获取每个音乐家的详细页面
                Document document = internetService.getDocByUrl(musicianUrl + cdMusician.getMusicianBdId());
                //获取音乐家的头像
                cdMusician.setMusicianBdImg(document.getElementsByClass("music-artist-img").get(0).attr("src"));
                //获取音乐家的热度
                cdMusician.setMusicianHot(document.getElementsByClass("hot-nums-detail").get(0).text());
                arr = document.getElementsByClass("area").get(0).text().split("： ");
                //地区
                if (arr.length > 1) {
                    cdMusician.setMusicianAddress(arr[1]);
                }
                //生辰
                if (document.getElementsByClass("birth").size() != 0) {
                    arr = document.getElementsByClass("birth").get(0).text().split("： ");
                    cdMusician.setMusicianBirth(arr[1]);
                }
                //获取音乐家的介绍
                if (document.getElementsByClass("introduce").size() > 0) {
                    cdMusician.setMusicianIntroduction(document.getElementsByClass("introduce").get(0).getElementsByClass("overdd").get(0).text());
                }
                cdMusician.setYn(new Byte("2"));
                cdMusicianService.updateByPrimaryKeySelective(cdMusician);
                //获取音乐列表
                Elements elements = document.getElementsByClass("songlist-item");
                for (Element element : elements) {
                    element1 = element.getElementsByClass("songlist-songname").get(0);
                    arr = element1.attr("href").split("/");
                    //音乐百度id
                    cdSong.setSongBdId(Long.parseLong(arr[2]));
                    //音乐名
                    cdSong.setSongName(element1.attr("title"));
                    element2 = element.getElementsByClass("album-name").get(0);
                    //专辑名
                    cdSong.setSongAlbum(element2.attr("title"));
                    element3 = element.getElementsByClass("songlist-time").get(0);
                    //音乐时长
                    cdSong.setSongLongTime(element3.text());
                    //音乐人id
                    cdSong.setSongMusicianId(cdMusician.getMusicianBdId());
                    jsonObject = getJsonByUrl(musicInfoUrl + cdSong.getSongBdId());
                    musicInfo = JSONObject.parseObject(jsonObject.toString(), new TypeReference<Map<String, String>>() {
                    });
                    musicInfo = JSONObject.parseObject(musicInfo.get("data").toString(), new TypeReference<Map<String, String>>() {
                    });
                    musicInfo = JSONObject.parseObject(musicInfo.get("songList").toString(), new TypeReference<Map<String, String>>() {
                    });
                    cdSong.setSongBgBg(musicInfo.get("songPicRadio"));
                    cdSong.setSongBgLg(musicInfo.get("songPicBig"));
                    cdSong.setSongBgSm(musicInfo.get("songPicSmall"));
                    cdSong.setSongLrcSrc(musicInfo.get("lrcLink"));
                    cdSong.setSongMp3Src(musicInfo.get("songLink"));
                    if (musicInfo.get("size") != "" && musicInfo.get("size") != null) {
                        cdSong.setSongSize(Integer.parseInt(String.valueOf(musicInfo.get("size"))));
                    }
                    LOGGER.info("百度音乐存入数据库详细信息：{}", BeanJsonUtil.bean2Json(cdSong));
                    cdSongService.insertSelective(cdSong);
                    Thread.sleep(3000);
                }
            }
        } catch (Exception e) {
            LOGGER.error("出错了{}", e);
        }
    }
}
