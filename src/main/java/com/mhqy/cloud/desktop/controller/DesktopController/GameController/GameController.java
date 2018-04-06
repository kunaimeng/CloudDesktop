package com.mhqy.cloud.desktop.controller.DesktopController.GameController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:游戏
 * @author: peiqiankun
 * @date: 2018/4/1
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Controller
public class GameController {

    @RequestMapping("game/dadishu")
    public String dadishu(){
        return "game/allGame/dadishu/index";
    }
}
