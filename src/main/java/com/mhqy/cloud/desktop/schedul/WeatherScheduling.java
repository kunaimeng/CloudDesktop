package com.mhqy.cloud.desktop.schedul;

import com.mhqy.cloud.desktop.service.internet.ReptileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * @Description:天气定时任务
 * @author: peiqiankun
 * @date: 2018/3/25
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Configuration
@EnableScheduling
public class WeatherScheduling {

    private final static Logger LOGGER = LoggerFactory.getLogger(WeatherScheduling.class);

    @Autowired
    private ReptileService reptileService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void getWeather() {
        LOGGER.info("[定时任务]获取天气");
        try {
            reptileService.getWeather();
        } catch (Exception e) {
            LOGGER.error("天气定时任务执行出现异常：{}", e);
        }
    }
}
