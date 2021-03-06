package com.mhqy.cloud.desktop.controller;

import com.mhqy.cloud.desktop.common.Constant;
import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.common.util.ListUtil;
import com.mhqy.cloud.desktop.domin.*;
import com.mhqy.cloud.desktop.domin.WeatherDomin.CDWeather;
import com.mhqy.cloud.desktop.service.address.CDAddressService;
import com.mhqy.cloud.desktop.service.desktop.CDDesktopService;
import com.mhqy.cloud.desktop.service.file.CDFileService;
import com.mhqy.cloud.desktop.service.internet.ReptileService;
import com.mhqy.cloud.desktop.service.soft.CDSoftwareService;
import com.mhqy.cloud.desktop.service.song.CDMusicianService;
import com.mhqy.cloud.desktop.service.song.CDSongService;
import com.mhqy.cloud.desktop.service.user.CDUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.nio.file.Paths;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private CDFileService cdFileService;

    @Autowired
    private CDUserService cdUserService;

    @Autowired
    private CDDesktopService cdDesktopService;

    @Autowired
    private CDSoftwareService cdSoftwareService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CDAddressService addressService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private CDMusicianService cdMusicianService;

    @Autowired
    private CDSongService cdSongService;

    @Autowired
    private ReptileService reptileService;

    @Value("${file.upload.path}")
    private String File_UPLOAN_PATH;

    @Value("${redis.key.news}")
    private String REDIS_KEY_NEWS;

    @Value("${redis.key.weather}")
    private String REDIS_KEY_WEATHER;

    @Value("${redis.key.column}")
    private String REDIS_KEY_COLUMN;

    @Value("${httpSession.uid}")
    private String HTTPSESSION_UID;

    @Value("${admin.auth.id}")
    private String ADMIN_AUTH_ID;

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
     * @Description:用户注册跳转
     * @author: peiqiankun
     * @date: 2018/2/25 20:41
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("register")
    public String register() {
        return "register";
    }

    /**
     * @Description:首页跳转
     * @author: peiqiankun
     * @date: 2018/2/25 20:41
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("index")
    public String index(Model model, HttpSession session) {
        Long httpSessionId = Long.parseLong(session.getAttribute(HTTPSESSION_UID).toString());
        //查询壁纸信息
        CDUser cdUser = cdUserService.selectByPrimaryKey(httpSessionId);
        if (StringUtils.equals(cdUser.getUserBgimg(), Constant.BACKGROUND_MAIN_URL_IMG.getDesc())) {
            model.addAttribute("mainBg", true);
        } else {
            model.addAttribute("mainBg", false);
        }
        if (StringUtils.equals(cdUser.getUserSmbgimg(), Constant.BACKGROUND_MOBILE_URL_IMG.getDesc())) {
            model.addAttribute("mobileBg", true);
        } else {
            model.addAttribute("mobileBg", false);
        }
        model.addAttribute("userInfo", cdUser);
        //查询安装软件
        List<CDDesktop> cdDesktopList = cdDesktopService.listSoftWareByUserId(httpSessionId);
        model.addAttribute("cdDesktopList", cdDesktopList);
        if (cdDesktopList.isEmpty()) {
            model.addAttribute("software", true);
        } else {
            model.addAttribute("software", false);
        }
        //判断是否是管理员
        String[] arr = ADMIN_AUTH_ID.split(",");
        List<String> stringList = Arrays.asList(arr);
        if (stringList.contains(cdUser.getUserPhone())) {
            model.addAttribute("isAdmin", cdUser.getUserPhone());
        } else {
            model.addAttribute("isAdmin", null);
        }
        List<CDFile> list = cdFileService.listMusic();
        model.addAttribute("musicList", list);
        return "desktop/index";
    }


    /**
     * @Description:软件中心
     * @author: peiqiankun
     * @date: 2018/5/30 21:05
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("software")
    public String software(Model model, HttpSession session) {
        LOGGER.info("进入软件中心");
        CDSoftware software = new CDSoftware();
        software.setYn(new Byte("1"));
        List<CDSoftware> cdSoftware = cdSoftwareService.listAllSoft(software);
        model.addAttribute("cdSoftware", cdSoftware);
        //查询安装软件
        List<CDDesktop> cdDesktopList = cdDesktopService.listSoftWareByUserId(Long.parseLong(session.getAttribute(HTTPSESSION_UID).toString()));
        List<String> result = new ArrayList<>();
        for (CDDesktop cdDesktop : cdDesktopList) {
            result.add(cdDesktop.getDesktopOpensrc());
        }
        model.addAttribute("cdDesktopList", result);
        return "software/index";
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
        cdFile.setFileUserId(Long.parseLong(session.getAttribute(HTTPSESSION_UID).toString()));
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
    public String clock() {
        return "desktop/clock";
    }

    /**
     * 万年历
     *
     * @Description:
     * @author: peiqiankun
     * @date: 2018/4/7 15:35
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("date")
    public String date() {
        return "desktop/date";
    }

    /**
     * @Description:音乐人跳转
     * @author: peiqiankun
     * @date: 2018/3/4 15:38
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("musician")
    public String musician(Model model) {
        CDMusician cdMusician = new CDMusician();
        cdMusician.setYn(new Byte("2"));
        List<CDMusician> list = cdMusicianService.listByCondition(cdMusician);
        model.addAttribute("musician", list);
        return "music/musician";
    }

    /**
     * @Description:音乐跳转
     * @author: peiqiankun
     * @date: 2018/6/12 17:19
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("music")
    public String music(Model model,CDSong cdSong) {
        List<CDSong> musicList = cdSongService.listByCondition(cdSong);
        model.addAttribute("musicList",musicList);
        return "music/music";
    }

    /**
     * @Description:视频播放器
     * @author: peiqiankun
     * @date: 2018/4/22 16:44
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("video")
    public String video(Model model) {
        List<CDFile> list = cdFileService.listMovie();
        model.addAttribute("movieList", list);
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
        if (!redisTemplate.hasKey(REDIS_KEY_WEATHER)) {
            LOGGER.info("缓存中不存在{}信息，开始爬取", REDIS_KEY_WEATHER);
            try {
                reptileService.getWeather();
            } catch (Exception e) {
                LOGGER.error("缓存中不存在{}信息，爬取失败：{}", REDIS_KEY_WEATHER, e);
            }
        }
        List<CDWeather> result = new ArrayList<>();
        LOGGER.info("天气搜索参数-->{}", BeanJsonUtil.bean2Json(cdWeather));
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
            LOGGER.error("查询天气异常：{}", e);
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
        LOGGER.info("开始初始化地址数据库");
        try {
            if (true) {
                throw new Exception("禁止调用初始化地址数据库");
            } else {
                List<CDAddress> addressList = addressService.selectFromRedis();
                LOGGER.info("地址数量：{}", addressList.size());
                for (CDAddress cdAddress : addressList) {
                    addressService.insert(cdAddress);
                }
            }
        } catch (Exception e) {
            LOGGER.error("初始化地址数据库失败：{}", e);
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
    public String explorer() {
        return "explorer/index";
    }

    /**
     * @Description:壁纸
     * @author: peiqiankun
     * @date: 2018/5/18 17:55
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("wallpaper")
    public String wallpaper(String href, Model model) {
        if (!redisTemplate.hasKey(REDIS_KEY_COLUMN)) {
            LOGGER.info("缓存中不存在{}信息，开始爬取", REDIS_KEY_COLUMN);
            try {
                reptileService.getWallpaper();
            } catch (Exception e) {
                LOGGER.error("缓存中不存在{}信息，爬取失败：{}", REDIS_KEY_COLUMN, e);
            }
        }
        List<Map<String, String>> list = (List<Map<String, String>>) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get(REDIS_KEY_COLUMN).toString(), List.class);
        model.addAttribute("column", list);
        if (href == null && !list.isEmpty()) {
            href = list.get(0).get("href");
        }
        List<Map<String, String>> photoList = (List<Map<String, String>>) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get(href).toString(), List.class);
        model.addAttribute("photoList", photoList);
        model.addAttribute("href", href);
        return "wallpaper/index";
    }


    /**
     * @Description:相册
     * @author: peiqiankun
     * @date: 2018/5/21 9:55
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("picture")
    public String picture(Model model, HttpSession session) {
        CDFile cdFile = new CDFile();
        cdFile.setFileUserId(Long.parseLong(session.getAttribute(HTTPSESSION_UID).toString()));
        List<CDFile> photoList = cdFileService.listPhonoByUser(cdFile);
        model.addAttribute("photoList", photoList);
        return "picture/index";
    }

    /**
     * @Description:文件展示 下载
     * @author: peiqiankun
     * @date: 2018/5/21 10:52
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(File_UPLOAN_PATH, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * @Description:文件下载
     * @author: peiqiankun
     * @date: 2018/5/28 10:54
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping(value = "/download/{filename:.+}")
    public ResponseEntity<?> listExport(@PathVariable String filename) {
        try {
            LOGGER.info("开始下载文件：{}", filename);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", "attachment; filename=" + filename);
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            Resource resource = resourceLoader.getResource("file:" + Paths.get(File_UPLOAN_PATH, filename).toString());
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(resourceLoader.getResource("file:" + Paths.get(File_UPLOAN_PATH, filename).toString()));
        } catch (Exception e) {
            LOGGER.error("下载文件失败：{}", e);
            return null;
        }
    }

    /**
     * @Description:新闻数据
     * @author: peiqiankun
     * @date: 2018/5/22 21:59
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("news")
    public String news(Model model) {
        if (!redisTemplate.hasKey(REDIS_KEY_NEWS)) {
            LOGGER.info("缓存中不存在{}信息，开始爬取", REDIS_KEY_NEWS);
            try {
                reptileService.getHotNews();
            } catch (Exception e) {
                LOGGER.error("缓存中不存在{}信息，爬取失败：{}", REDIS_KEY_NEWS, e);
            }
        }
        List<CDNews> news = (List<CDNews>) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get(REDIS_KEY_NEWS).toString(), List.class);
        model.addAttribute("news", news);
        return "news/index";
    }

    /**
     * @Description:聊天
     * @author: peiqiankun
     * @date: 2018/5/23 18:09
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("chat")
    public String chat(Model model, HttpSession session) {
        model.addAttribute("userInfo", cdUserService.selectByPrimaryKey(Long.parseLong(session.getAttribute(HTTPSESSION_UID).toString())));
        return "chat/index";
    }

    /**
     * @Description:朱传涵
     * @author: peiqiankun
     * @date: 2018/5/28 17:09
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("updateinfo")
    public String updateinfo() {
        LOGGER.info("访问安全卫士更新页面");
        return "updateinfo/index";
    }

    /**
     * @Description:地图
     * @author: peiqiankun
     * @date: 2018/6/3 15:41
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("map")
    public String map() {
        return "map/index";
    }
}
