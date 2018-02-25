package com.mhqy.cloud.desktop.controller.DesktopController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("index")
    public String index(){
        logger.info("进来了");
        return "login";
    }

}
