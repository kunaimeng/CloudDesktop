package com.mhqy.cloud.desktop.config;

import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.service.internet.InternetService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:桌面壁纸
 * @author: peiqiankun
 * @date: 2018/5/19
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Configuration
@EnableScheduling
public class WallpaperSchedulingConfig {

    private final static Logger logger = LoggerFactory.getLogger(WallpaperSchedulingConfig.class);

    @Autowired
    private InternetService internetService;

    @Autowired
    private RedisTemplate redisTemplate;


    @Scheduled(cron = "0 0 0/1 * * ?")
    public void getWeather() {
        logger.info("桌面壁纸任务开始执行");
        try {
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
                for( Map<String, String> map:column){
                    logger.info("爬取壁纸数据href:{}",map.get("href"));
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
        } catch (Exception e) {
            logger.error("桌面壁纸任务开始执行异常：{}", e.getMessage());
        }
    }
}