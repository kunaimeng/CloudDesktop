package com.mhqy.cloud.desktop.controller.desktop.game;

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
    public String dadishu() {
        return "game/allGame/dadishu/index";
    }

    @RequestMapping("game/buyvdaren")
    public String buyvdaren() {
        return "game/allGame/buyvdaren/index";
    }

}
