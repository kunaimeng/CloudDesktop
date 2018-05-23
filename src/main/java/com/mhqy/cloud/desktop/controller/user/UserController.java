package com.mhqy.cloud.desktop.controller.user;

import com.mhqy.cloud.desktop.domin.CDUser;
import com.mhqy.cloud.desktop.service.user.CDUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
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
            cdUser.setUserPassword(DigestUtils.md5DigestAsHex(cdUser.getUserPassword().getBytes()));
            map = userService.userLogin(cdUser);
            if ((boolean) map.get("flag")) {
                String uid = map.get("Uid").toString();
                logger.info("用户登录成功-->Uid:{}", uid);
                session.setAttribute("Uid", uid);
                map.put("msg", "登录成功");
            } else {
                logger.info("用户登录失败-->UName:{}", cdUser.getUserPhone());
                map.put("msg", "登录失败");
            }
        } catch (Exception e) {
            logger.error("用户登录发生异常-->{}", e);
            map = new HashMap<String, Object>();
            map.put("flag", false);
            map.put("msg", e);
        } finally {
            return map;
        }
    }
}
