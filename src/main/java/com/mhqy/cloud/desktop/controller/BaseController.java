package com.mhqy.cloud.desktop.controller;

import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.common.util.ListUtil;
import com.mhqy.cloud.desktop.domin.CDAddress;
import com.mhqy.cloud.desktop.domin.CDFile;
import com.mhqy.cloud.desktop.domin.WeatherDomin.CDWeather;
import com.mhqy.cloud.desktop.service.CDAddressService.CDAddressService;
import com.mhqy.cloud.desktop.service.CDFileService.CDFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class BaseController {

    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private CDFileService cdFileService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CDAddressService addressService;

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

    /**
     * @Description:游戏
     * @author: peiqiankun
     * @date: 2018/4/1 20:50
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("game")
    public String game() {
        return "game/index";
    }

    /**
     * @Description:天气
     * @author: peiqiankun
     * @date: 2018/3/24 14:30
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("weather")
    public String weather(Model model) {
        List<CDWeather> result = new ArrayList<>();
        try {
            List<CDAddress> list = addressService.selectByRand();
            if (ListUtil.isNotEmpty(list)) {
                CDWeather cdWeather;
                for (CDAddress cdAddress : list) {
                    cdWeather = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get(cdAddress.getAddressPlatId().toString()).toString(), CDWeather.class);
                    result.add(cdWeather);
                }
            }
            model.addAttribute("content", result);
            //查询所有地址
            List<CDAddress> addressList = addressService.selectAllContent();
            model.addAttribute("address", addressList);
        } catch (Exception e) {
            logger.error("查询天气异常：{}", e.getMessage());
        } finally {
            return "weather/index";
        }
    }

    /**
     * @Description:初始化地址数据库 禁止调用
     * @author: peiqiankun
     * @date: 2018/3/31 20:02
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("initAddress")
    @ResponseBody
    public String initAddress() {
        logger.info("开始初始化地址数据库");
        try {
            if (true) {
                throw new Exception("禁止调用初始化地址数据库");
            } else {
                List<CDAddress> addressList = addressService.selectFromRedis();
                logger.info("地址数量：{}", addressList.size());
                for (CDAddress cdAddress : addressList) {
                    addressService.insert(cdAddress);
                }
            }
        } catch (Exception e) {
            logger.error("初始化地址数据库失败：{}", e.getMessage());
        } finally {
            return "禁止调用初始化地址数据库";
        }
    }
}
