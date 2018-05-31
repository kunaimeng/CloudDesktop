package com.mhqy.cloud.desktop.controller.desktop.desk;

import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.domin.CDDesktop;
import com.mhqy.cloud.desktop.service.desktop.CDDesktopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:桌面controller
 * @author: peiqiankun
 * @date: 2018/5/31
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@RestController
public class DeskController {

    private final static Logger LOGGER = LoggerFactory.getLogger(DeskController.class);

    @Value("${httpSession.uid}")
    private String HTTPSESSION_UID;

    @Autowired
    private CDDesktopService cdDesktopService;

    /**
     * @Description:桌面安装软件
     * @author: peiqiankun
     * @date: 2018/5/31 10:17
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("insertDesk")
    public Map<String, Object> insertDesk(CDDesktop cdDesktop, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            LOGGER.info("{}:开始安装软件：{}", session.getAttribute(HTTPSESSION_UID), BeanJsonUtil.bean2Json(cdDesktop));
            cdDesktop.setDesktopUserId(Long.parseLong(session.getAttribute(HTTPSESSION_UID).toString()));
            int i = cdDesktopService.insertSelective(cdDesktop);
            if (i == 1) {
                map.put("flag", true);
                map.put("msg", "操作成功");
            } else {
                map.put("flag", false);
                map.put("msg", "操作失败");
            }
            return map;
        } catch (Exception e) {
            LOGGER.error("{}:开始安装软件：{},失败：{}", session.getAttribute(HTTPSESSION_UID), BeanJsonUtil.bean2Json(cdDesktop), e);
            map.put("flag", false);
            map.put("msg", e);
            return map;
        }
    }
}
