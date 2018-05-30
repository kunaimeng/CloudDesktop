package com.mhqy.cloud.desktop.controller.user;

import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.domin.CDFile;
import com.mhqy.cloud.desktop.domin.CDUser;
import com.mhqy.cloud.desktop.service.fileupload.FileUploadService;
import com.mhqy.cloud.desktop.service.user.CDUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private CDUserService userService;

    @Autowired
    private FileUploadService fileUploadService;

    @Value("${httpSession.uid}")
    private String HTTPSESSION_UID;

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
                String uid = map.get(HTTPSESSION_UID).toString();
                LOGGER.info("用户登录成功-->HTTPSESSION_UID:{}", uid);
                session.setAttribute(HTTPSESSION_UID, uid);
                map.put("msg", "登录成功");
            } else {
                LOGGER.info("用户登录失败-->UName:{}", cdUser.getUserPhone());
                map.put("msg", "登录失败");
            }
        } catch (Exception e) {
            LOGGER.error("用户登录发生异常-->{}", e);
            map = new HashMap<String, Object>();
            map.put("flag", false);
            map.put("msg", e);
        } finally {
            return map;
        }
    }

    /**
     * @Description:用户注册跳转
     * @author: peiqiankun
     * @date: 2018/2/25 20:41
     * @mail: peiqiankun@jd.com
     */
    @PostMapping("userRegister")
    public Map<String, Object> userRegister(CDUser cdUser) {
        Map<String, Object> map = new HashMap<>();
        try {
            cdUser.setUserPassword(DigestUtils.md5DigestAsHex(cdUser.getUserPassword().getBytes()));
            cdUser.setCreateTime(new Date());
            cdUser.setUpdateTime(new Date());
            LOGGER.info("用户注册信息：{}", BeanJsonUtil.bean2Json(cdUser));
            int i = userService.insertSelective(cdUser);
            if (i == 1) {
                map.put("flag", true);
                map.put("msg", "成功");
            } else {
                map.put("flag", false);
                map.put("msg", "失败");
            }
        } catch (Exception e) {
            map.put("flag", false);
            map.put("msg", e);
        }
        return map;
    }

    /**
     * @Description:用户头像上传
     * @author: peiqiankun
     * @date: 2018/5/30 11:54
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("userPhotoUpload")
    public Map<String, Object> userPhotoUpload(@RequestParam("file") MultipartFile file) {
        Map<String, Object> map = new HashMap<>();
        try {
            LOGGER.info("用户头像上传参数:{}", BeanJsonUtil.bean2Json(file));
            CDFile cdFile = fileUploadService.upload(file);
            map.put("code", 1);
            map.put("msg", cdFile.getFileSystemName());
            LOGGER.info("用户头像上传成功：{}", BeanJsonUtil.bean2Json(cdFile));
        } catch (Exception e) {
            map.put("code", 0);
            map.put("msg", e);
            LOGGER.error("用户头像上传失败，原因：{}", e);
        }
        return map;
    }
}
