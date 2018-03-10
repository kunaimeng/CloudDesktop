package com.mhqy.cloud.desktop.controller.UserController;

import com.mhqy.cloud.desktop.controller.ErrorController;
import com.mhqy.cloud.desktop.domin.CDUser;
import com.mhqy.cloud.desktop.service.CDUserService.CDUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:用户Controller
 * @author: peiqiankun
 * @date: 2018/3/10
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@RestController
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private CDUserService userService;

    /**
     * @Description:用户登录
     * @author: peiqiankun
     * @date: 2018/3/10 20:46
     * @mail: peiqiankun@jd.com
     */
    @PostMapping("userLogin")
    public Map<String, Object> userLogin(CDUser cdUser, HttpSession session) {
        Map<String, Object> map = null;
        try {
            map = userService.userLogin(cdUser);
            if ((boolean) map.get("flag")) {
                String uid = map.get("Uid").toString();
                logger.info("用户登录成功-->Uid:{}", uid);
                session.setAttribute("Uid", uid);
                map.put("msg", "登录成功");
            } else {
                logger.info("用户登录失败-->UName:{},UPassWd:{}", cdUser.getUserPhone(), cdUser.getUserPassword());
                map.put("msg", "登录失败");
            }
        } catch (Exception e) {
            logger.error("用户登录发生异常-->{}", e.getMessage());
            map = new HashMap<String, Object>();
            map.put("flag", false);
            map.put("msg", e.getMessage());
        } finally {
            return map;
        }
    }
}
