package com.mhqy.cloud.desktop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:错误处理
 * @author: peiqiankun
 * @date: 2018/3/4
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Controller
@RequestMapping("ErrorPage")
public class ErrorController {

    private final static Logger logger = LoggerFactory.getLogger(ErrorController.class);

    /**
     * @Description:400处理
     * @author: peiqiankun
     * @date: 2018/3/4 14:18
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("400")
    public String error400(Model model){
        logger.error("程序发生400错误,请检查!");
        model.addAttribute("msg","程序发生404错误，请联系攻城狮！");
        model.addAttribute("email","peiqiankun@jd.com");
        return "errorPage/error";
    }

    /**
     * @Description:401处理
     * @author: peiqiankun
     * @date: 2018/3/4 14:18
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("401")
    public String error401(Model model){
        logger.error("程序发生401错误,请检查!");
        model.addAttribute("msg","程序发生40错误，请联系攻城狮！");
        model.addAttribute("email","peiqiankun@jd.com");
        return "errorPage/error";
    }

    /**
     * @Description:404处理
     * @author: peiqiankun
     * @date: 2018/3/4 14:18
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("404")
    public String error404(Model model){
        logger.error("程序发生404错误,请检查!");
        model.addAttribute("msg","程序发生404错误，请联系攻城狮！");
        model.addAttribute("email","peiqiankun@jd.com");
        return "errorPage/error";
    }

    /**
     * @Description:500处理
     * @author: peiqiankun
     * @date: 2018/3/4 14:19
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("500")
    public String error500(Model model){
        logger.error("程序发生500错误,请检查!");
        model.addAttribute("msg","程序发生500错误，请联系攻城狮！");
        model.addAttribute("email","peiqiankun@jd.com");
        return "errorPage/error";
    }

}
