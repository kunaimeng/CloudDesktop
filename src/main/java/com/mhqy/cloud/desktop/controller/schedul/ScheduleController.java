package com.mhqy.cloud.desktop.controller.schedul;

import com.mhqy.cloud.desktop.service.internet.ReptileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:定时任务手动执行
 * @author: peiqiankun
 * @date: 2018/5/23
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Controller
@RequestMapping("schedule")
public class ScheduleController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

    @Autowired
    private ReptileService reptileService;

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
}