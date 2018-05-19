package com.mhqy.cloud.desktop.controller;

import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.common.util.ListUtil;
import com.mhqy.cloud.desktop.domin.CDAddress;
import com.mhqy.cloud.desktop.domin.CDFile;
import com.mhqy.cloud.desktop.domin.WeatherDomin.CDWeather;
import com.mhqy.cloud.desktop.service.address.CDAddressService;
import com.mhqy.cloud.desktop.service.file.CDFileService;
import com.mhqy.cloud.desktop.service.internet.InternetService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;


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

    @Autowired
    private InternetService internetService;

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
     * @Description:时钟
     * @author: peiqiankun
     * @date: 2018/4/7 15:00
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("clock")
    public String clock(){
        return "desktop/clock";
    }

    /**万年历
     * @Description:
     * @author: peiqiankun
     * @date: 2018/4/7 15:35
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("date")
    public String date(){
        return "desktop/date";
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
     * @Description:视频播放器
     * @author: peiqiankun
     * @date: 2018/4/22 16:44
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("video")
    public String video() {
        return "video/index";
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
    public String weather(Model model, CDWeather cdWeather) {
        List<CDWeather> result = new ArrayList<>();
        logger.info("天气搜索参数-->{}", BeanJsonUtil.bean2Json(cdWeather));
        CDWeather cdWeatherResult;
        try {
            if (cdWeather.getAddressId() != null) {
                cdWeatherResult = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get(cdWeather.getAddressId()).toString(), CDWeather.class);
                result.add(cdWeatherResult);
            } else {
                List<CDAddress> list = addressService.selectByRand();
                if (ListUtil.isNotEmpty(list)) {
                    for (CDAddress cdAddress : list) {
                        cdWeatherResult = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get(cdAddress.getAddressPlatId().toString()).toString(), CDWeather.class);
                        result.add(cdWeatherResult);
                    }
                }
            }
            model.addAttribute("content", result);
            //查询所有地址
            List<CDAddress> addressList = addressService.selectAllContent();
            model.addAttribute("address", addressList);
            model.addAttribute("search", cdWeather);
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

    /**
     * @Description:浏览器
     * @author: peiqiankun
     * @date: 2018/5/18 17:56
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("explorer")
    public String explorer(){
        return "explorer/index";
    }

    /**
     * @Description:壁纸
     * @author: peiqiankun
     * @date: 2018/5/18 17:55
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("wallpaper")
    public String wallpaper(String href, String keyWord, Model model) {
        List<Map<String, String>> column = new ArrayList<>();
        Document document = internetService.getDocByUrl("http://www.5857.com/list-9-0-3366-0-3395-0-1.html");
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
        model.addAttribute("column", column);

        List<Map<String, String>> photoList = new ArrayList<>();
        if(!column.isEmpty()){
            Map<String, String> map = column.get(0);
            Document doc = internetService.getDocByUrl(map.get("href"));
            Elements docElementsByClass = doc.getElementsByClass("piclist");
            for (Element element : docElementsByClass) {
                Elements elementsByTags = element.getElementsByClass("listbox");
                for (Element tag:elementsByTags){
                    doc = internetService.getDocByUrl(tag.select("a").attr("href"));
                    Elements photoElements = doc.getElementsByClass("photo-a");
                    for(Element photo:photoElements){
                        Map<String, String> photoMap = new HashMap<>();
                        photoMap.put("src",photo.select("img").attr("src"));
                        photoMap.put("title",photo.select("img").attr("alt"));
                        photoList.add(photoMap);
                    }
                }
            }
        }

        model.addAttribute("photoList", photoList);
        return "wallpaper/index";
    }
}
