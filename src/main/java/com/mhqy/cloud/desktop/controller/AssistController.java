package com.mhqy.cloud.desktop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:辅助功能 跳转
 * @author: peiqiankun
 * @date: 2018/6/3
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Controller
@RequestMapping("assist")
public class AssistController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AssistController.class);

    @RequestMapping("calculator")
    public String calculator() {
        LOGGER.info("进入网页计算器");
        return "assist/calculator";
    }
}
