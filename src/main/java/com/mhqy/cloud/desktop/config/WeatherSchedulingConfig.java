package com.mhqy.cloud.desktop.config;

import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.domin.WeatherDomin.CDWeather;
import com.mhqy.cloud.desktop.service.internet.InternetService;
import com.mhqy.cloud.desktop.service.weather.WeatherService;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:天气定时任务
 * @author: peiqiankun
 * @date: 2018/3/25
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Configuration
@EnableScheduling
public class WeatherSchedulingConfig {

    private final static Logger logger = LoggerFactory.getLogger(WeatherSchedulingConfig.class);

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private InternetService internetService;

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void getWeather() {
        logger.info("天气定时任务开始执行");
        try {
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
                logger.info("开始存入redis天气信息 key:{},value:{}", cdWeather.getAddressId(), BeanJsonUtil.bean2Json(cdWeather));
                redisTemplate.opsForValue().set(cdWeather.getAddressId(), BeanJsonUtil.bean2Json(cdWeather));
            }
        } catch (Exception e) {
            logger.error("天气定时任务执行出现异常：{}", e.getMessage());
        }
    }
}
