package com.mhqy.cloud.desktop.controller;

import com.mhqy.cloud.desktop.domin.CDFile;
import com.mhqy.cloud.desktop.service.CDFileService.CDFileService;
import com.mhqy.cloud.desktop.service.CDUserService.CDUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
        model.addAttribute("content",list);
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
}
