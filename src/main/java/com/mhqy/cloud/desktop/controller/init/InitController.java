package com.mhqy.cloud.desktop.controller.init;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.JsonObject;
import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.domin.CDMusician;
import com.mhqy.cloud.desktop.domin.CDSocketMessage;
import com.mhqy.cloud.desktop.domin.CDSong;
import com.mhqy.cloud.desktop.service.internet.InternetService;
import com.mhqy.cloud.desktop.service.internet.ReptileService;
import com.mhqy.cloud.desktop.service.song.CDMusicianService;
import com.mhqy.cloud.desktop.service.song.CDSongService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description:定时任务手动执行
 * @author: peiqiankun
 * @date: 2018/5/23
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Controller
@RequestMapping("init")
public class InitController {

    private final static Logger LOGGER = LoggerFactory.getLogger(InitController.class);

    @Autowired
    private ReptileService reptileService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private InternetService internetService;

    @Autowired
    private CDMusicianService cdMusicianService;

    @Autowired
    private CDSongService cdSongService;

    /**
     * @Description:手动执行爬取新闻信息任务
     * @author: peiqiankun
     * @date: 2018/5/23 10:52
     * @mail: peiqiankun@jd.com
     */
    @ResponseBody
    @RequestMapping(value = "newsSchedule", produces = "application/json;charset=utf-8")
    public String newsSchedule() {
        LOGGER.info("[手动执行定时任务]爬取新闻信息");
        try {
            reptileService.getHotNews();
            return "[手动执行定时任务]爬取新闻信息-成功";
        } catch (Exception e) {
            LOGGER.error("[手动执行定时任务]爬取新闻信息失败：{}", e);
            return "[手动执行定时任务]爬取新闻信息-失败";
        }
    }

    /**
     * @Description:手动执行爬取壁纸信息任务
     * @author: peiqiankun
     * @date: 2018/5/23 10:53
     * @mail: peiqiankun@jd.com
     */
    @ResponseBody
    @RequestMapping(value = "wallpaperSchedule", produces = "application/json;charset=utf-8")
    public String wallpaperSchedule() {
        LOGGER.info("[手动执行定时任务]爬取壁纸信息");
        try {
            reptileService.getWallpaper();
            return "[手动执行定时任务]爬取壁纸信息-成功";
        } catch (Exception e) {
            LOGGER.error("[手动执行定时任务]爬取壁纸信息失败：{}", e);
            return "[手动执行定时任务]爬取壁纸信息-失败";
        }
    }

    /**
     * @Description:手动执行爬取天气信息任务
     * @author: peiqiankun
     * @date: 2018/5/23 10:53
     * @mail: peiqiankun@jd.com
     */
    @ResponseBody
    @RequestMapping(value = "weatherSchedule", produces = "application/json;charset=utf-8")
    public String weatherSchedule() {
        LOGGER.info("[手动执行定时任务]爬取天气信息");
        try {
            reptileService.getWeather();
            return "[手动执行定时任务]爬取天气信息-成功";
        } catch (Exception e) {
            LOGGER.error("[手动执行定时任务]爬取天气信息失败：{}", e);
            return "[手动执行定时任务]爬取天气信息-失败";
        }
    }

    @RequestMapping("promptAdd")
    public String promptAdd() {
        return "promptAdd/index";
    }

    /**
     * @Description:初始化redis提示用语
     * @author: peiqiankun
     * @date: 2018/5/23 15:29
     * @mail: peiqiankun@jd.com
     */
    @ResponseBody
    @RequestMapping(value = "promptSchedule")
    public Map<String, Object> promptSchedule(CDSocketMessage cdSocketMessage) {
        Map<String, Object> map = new HashMap<String, Object>();
        LOGGER.info("[初始化提示用语]内容：{}", BeanJsonUtil.bean2Json(cdSocketMessage));
        try {
            Assert.notNull(cdSocketMessage.getMessage(), "数据内容不能为空");
            Assert.notNull(cdSocketMessage.getTitle(), "标题内容不能为空");
            redisTemplate.opsForValue().set("prompt", BeanJsonUtil.bean2Json(cdSocketMessage));
            map.put("flag", true);
            map.put("msg", "操作成功");
            return map;
        } catch (Exception e) {
            LOGGER.error("[初始化提示用语]失败：con:{}，msg:{}", BeanJsonUtil.bean2Json(cdSocketMessage), e);
            map.put("flag", false);
            map.put("msg", e);
            return map;
        }
    }

    /**
     * @Description:初始化歌手信息
     * @author: peiqiankun
     * @date: 2018/6/11 18:16
     * @mail: peiqiankun@jd.com
     */
    @ResponseBody
    @RequestMapping(value = "musicianData")
    public String promptSchedule() {
        LOGGER.info("[初始化歌手信息]");
        try {
            reptileService.getBaiduMp3();
            return "[初始化歌手信息]成功";
        } catch (Exception e) {
            LOGGER.error("出错了{}", e);
            return "[初始化歌手信息]失败";
        }
    }

    @ResponseBody
    @RequestMapping("getMusicianInfoAndMuisc")
    public String getMusicianInfoAndMuisc() {
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
                LOGGER.info("查询音乐家的详细信息：音乐家Id{},音乐家名称：{}",cdMusician.getMusicianBdId(),cdMusician.getMusicianName());
                //获取每个音乐家的详细页面
                Document document = internetService.getDocByUrl(musicianUrl+cdMusician.getMusicianBdId());
                //获取音乐家的头像
                cdMusician.setMusicianBdImg(document.getElementsByClass("music-artist-img").get(0).attr("src"));
                //获取音乐家的热度
                cdMusician.setMusicianHot(document.getElementsByClass("hot-nums-detail").get(0).text());
                arr = document.getElementsByClass("area").get(0).text().split("： ");
                //地区
                if(arr.length>1){
                    cdMusician.setMusicianAddress(arr[1]);
                }
                //生辰
                if(document.getElementsByClass("birth").size()!=0){
                    arr = document.getElementsByClass("birth").get(0).text().split("： ");
                    cdMusician.setMusicianBirth(arr[1]);
                }
                //获取音乐家的介绍
                cdMusician.setMusicianIntroduction(document.getElementsByClass("introduce").get(0).getElementsByClass("overdd").get(0).text());
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
                    jsonObject = reptileService.getJsonByUrl(musicInfoUrl+cdSong.getSongBdId());
                    musicInfo = JSONObject.parseObject(jsonObject.toString(), new TypeReference<Map<String, String>>(){});
                    musicInfo = JSONObject.parseObject( musicInfo.get("data").toString(), new TypeReference<Map<String, String>>(){});
                    musicInfo = JSONObject.parseObject( musicInfo.get("songList").toString(), new TypeReference<Map<String, String>>(){});
                    cdSong.setSongBgBg(musicInfo.get("songPicRadio"));
                    cdSong.setSongBgLg(musicInfo.get("songPicBig"));
                    cdSong.setSongBgSm(musicInfo.get("songPicSmall"));
                    cdSong.setSongLrcSrc(musicInfo.get("lrcLink"));
                    cdSong.setSongMp3Src(musicInfo.get("songLink"));
                    cdSong.setSongSize(Integer.parseInt(String.valueOf(musicInfo.get("size"))));
                    LOGGER.info("百度音乐存入数据库详细信息：{}",BeanJsonUtil.bean2Json(cdSong));
                    cdSongService.insertSelective(cdSong);
                    Thread.sleep(3000);
                }
            }
            return "[从百度音乐查询歌手所属歌曲]成功";
        } catch (Exception e) {
            LOGGER.error("出错了{}", e);
            return "[从百度音乐查询歌手所属歌曲]失败";
        }
    }
}