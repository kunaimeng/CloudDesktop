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
            reptileService.getBaiduMusician();
            return "[初始化歌手信息]成功";
        } catch (Exception e) {
            LOGGER.error("出错了{}", e);
            return "[初始化歌手信息]失败";
        }
    }

    /**
     * @Description:百度音乐爬虫继续执行
     * @author: peiqiankun
     * @date: 2018/6/12 15:54
     * @mail: peiqiankun@jd.com
     */
    @ResponseBody
    @RequestMapping(value = "getMusicianInfoAndMuisc", produces = "application/json;charset=utf-8")
    public String getMusicianInfoAndMuisc() {
        try {
            LOGGER.info("继续执行百度音乐爬虫任务");
            reptileService.getMusicianInfoAndMuisc();
            return "百度音乐爬虫完毕";
        } catch (Exception e) {
            LOGGER.info("执行百度音乐爬虫任务出现异常，请继续重试。原因：{}", e);
            return "执行百度音乐爬虫任务出现异常，请继续重试。原因：" + e;
        }
    }
}