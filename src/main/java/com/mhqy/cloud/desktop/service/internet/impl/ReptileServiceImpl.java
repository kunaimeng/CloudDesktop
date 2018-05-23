package com.mhqy.cloud.desktop.service.internet.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.domin.CDNews;
import com.mhqy.cloud.desktop.domin.WeatherDomin.CDWeather;
import com.mhqy.cloud.desktop.service.internet.InternetService;
import com.mhqy.cloud.desktop.service.internet.ReptileService;
import com.mhqy.cloud.desktop.service.weather.WeatherService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * @Description:获取热点信息
     * @author: peiqiankun
     * @date: 2018/5/23 10:15
     * @mail: peiqiankun@jd.com
     */
    @Override
    public void getHotNews() throws Exception {
        LOGGER.info("新闻定时任务开始执行");
        String path = "http://v.juhe.cn/toutiao/index?type=top&key=270bcc91e2a8ef430f74e8319e6af774";
        URL url = new URL(path);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
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
        JsonObject jsonObject = (JsonObject) parse.parse(bos.toString("utf-8"));
        JsonObject result = (JsonObject) jsonObject.get("result");
        List<CDNews> cdNews = (List) BeanJsonUtil.json2Object(result.get("data").toString(), List.class);
        LOGGER.info("新闻存入redis信息：key:{},value:{}", "news", cdNews);
        redisTemplate.opsForValue().set("news", BeanJsonUtil.bean2Json(cdNews));
    }

    /**
     * @Description:获取壁纸信息
     * @author: peiqiankun
     * @date: 2018/5/23 10:15
     * @mail: peiqiankun@jd.com
     */
    @Override
    public void getWallpaper() throws Exception {
        LOGGER.info("壁纸定时任务开始执行");
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
        redisTemplate.opsForValue().set("column", BeanJsonUtil.bean2Json(column));
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
    }

    /**
     * @Description:获取天气信息
     * @author: peiqiankun
     * @date: 2018/5/23 10:15
     * @mail: peiqiankun@jd.com
     */
    @Override
    public void getWeather() throws Exception {
        LOGGER.info("天气定时任务开始执行");
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
    }
}
