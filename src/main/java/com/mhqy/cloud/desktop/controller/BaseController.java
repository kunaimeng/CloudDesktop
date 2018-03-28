package com.mhqy.cloud.desktop.controller;

import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.domin.CDFile;
import com.mhqy.cloud.desktop.domin.WeatherDomin.CDWeather;
import com.mhqy.cloud.desktop.service.CDFileService.CDFileService;
import com.mhqy.cloud.desktop.service.CDUserService.CDUserService;
import com.mhqy.cloud.desktop.service.WeatherService.WeatherService;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description:首页Controller
 * @author: peiqiankun
 * @date: 2018/2/25
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Controller
@EnableScheduling
public class BaseController {

    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private CDUserService userService;

    @Autowired
    private CDFileService cdFileService;

    @Autowired
    private WeatherService weatherService;

    /**
     * @Description:登录页跳转
     * @author: peiqiankun
     * @date: 2018/2/25 20:40
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("/")
    public String login() {
        return "login";
    }

    /**
     * @Description:首页跳转
     * @author: peiqiankun
     * @date: 2018/2/25 20:41
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("index")
    public String index() {
        return "desktop/index";
    }

    /**
     * @Description:我的电脑
     * @author: peiqiankun
     * @date: 2018/3/3 15:12
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("file")
    public String file(Model model, HttpSession session) {
        CDFile cdFile = new CDFile();
        cdFile.setFileUserId(Long.parseLong(session.getAttribute("Uid").toString()));
        cdFile.setFileParentId(new Long(0));
        cdFile.setYn(new Byte("1"));
        List<CDFile> list = cdFileService.selectByFile(cdFile);
        model.addAttribute("content", list);
        return "file/index";
    }

    /**
     * @Description:音乐跳转
     * @author: peiqiankun
     * @date: 2018/3/4 15:38
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("music")
    public String music() {
        return "music/index";
    }


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @Description:天气
     * @author: peiqiankun
     * @date: 2018/3/24 14:30
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("weather")
    public String weather(Model model) {
        List<CDWeather> list = new ArrayList<>();
        CDWeather cdWeather101010100 = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get("101010100").toString(), CDWeather.class);
        CDWeather cdWeather101220101 = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get("101220101").toString(), CDWeather.class);
        CDWeather cdWeather101040100 = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get("101040100").toString(), CDWeather.class);
        CDWeather cdWeather101230101 = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get("101230101").toString(), CDWeather.class);
        CDWeather cdWeather101160101 = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get("101160101").toString(), CDWeather.class);
        CDWeather cdWeather101280101 = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get("101280101").toString(), CDWeather.class);
        CDWeather cdWeather101180101 = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get("101180101").toString(), CDWeather.class);
        CDWeather cdWeather101150101 = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get("101150101").toString(), CDWeather.class);
        CDWeather cdWeather101140101 = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get("101140101").toString(), CDWeather.class);
        CDWeather cdWeather101290101 = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get("101290101").toString(), CDWeather.class);
        list.add(cdWeather101010100);
        list.add(cdWeather101220101);
        list.add(cdWeather101040100);
        list.add(cdWeather101230101);
        list.add(cdWeather101160101);
        list.add(cdWeather101280101);
        list.add(cdWeather101180101);
        list.add(cdWeather101150101);
        list.add(cdWeather101140101);
        list.add(cdWeather101290101);
        model.addAttribute("content", list);
        return "weather/index";
    }
}
