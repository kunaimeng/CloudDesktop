package com.mhqy.cloud.desktop.schedul;

import com.mhqy.cloud.desktop.service.internet.ReptileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * @Description:桌面壁纸
 * @author: peiqiankun
 * @date: 2018/5/19
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Configuration
@EnableScheduling
public class WallpaperScheduling {

    private final static Logger LOGGER = LoggerFactory.getLogger(WallpaperScheduling.class);

    @Autowired
    private ReptileService reptileService;

    @Scheduled(cron = "0 0 8 * * ?")
    public void getWallpaper() {
        LOGGER.info("[定时任务]桌面壁纸任务");
        try {
            reptileService.getWeather();
        } catch (Exception e) {
            LOGGER.error("桌面壁纸任务开始执行异常：{}", e.getMessage());
        }
    }
}