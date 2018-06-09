package com.mhqy.cloud.desktop.controller.desktop.soft;

import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.domin.CDSoftware;
import com.mhqy.cloud.desktop.service.soft.CDSoftwareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/6/2
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Controller
@RequestMapping("soft")
public class SoftController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SoftController.class);

    @Value("${httpSession.uid}")
    private String HTTPSESSION_UID;

    @Autowired
    private CDSoftwareService cdSoftwareService;

    /**
     * @Description:软件index
     * @author: peiqiankun
     * @date: 2018/6/8 23:10
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("index")
    public String soft(Model model) {
        CDSoftware cdSoftware = new CDSoftware();
        List<CDSoftware> softList = cdSoftwareService.listAllSoft(cdSoftware);
        model.addAttribute("softList", softList);
        return "soft/index";
    }

    /**
     * @Description:系统初始化软件录入界面
     * @author: peiqiankun
     * @date: 2018/6/2 20:37
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("add")
    public String softAdd() {
        return "soft/add";
    }

    /**
     * @Description:软件更新跳转
     * @author: peiqiankun
     * @date: 2018/6/9 16:22
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("update")
    public String update(Model model,CDSoftware cdSoftware) {
        CDSoftware soft = cdSoftwareService.selectByPrimaryKey(cdSoftware.getSoftId());
        model.addAttribute("soft",soft);
        return "soft/update";
    }

    /**
     * @Description:软件更新
     * @author: peiqiankun
     * @date: 2018/6/9 16:31
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("softUpdate")
    @ResponseBody
    public Map<String, Object>  softUpdate(HttpSession session,CDSoftware cdSoftware) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            LOGGER.info("{}:软件更新:{}", session.getAttribute(HTTPSESSION_UID),BeanJsonUtil.bean2Json(cdSoftware));
            int i = cdSoftwareService.updateByPrimaryKeySelective(cdSoftware);
            if (i == 1) {
                map.put("flag", true);
                map.put("msg", "操作成功");
            } else {
                map.put("flag", false);
                map.put("msg", "操作失败");
            }
            return map;
        }catch(Exception e){
            LOGGER.error("{}:软件更新:{},失败,原因:{}", session.getAttribute(HTTPSESSION_UID),BeanJsonUtil.bean2Json(cdSoftware),e);
            map.put("flag", false);
            map.put("msg", e);
            return map;
        }
    }

    /**
     * @Description:管理员软件安装
     * @author: peiqiankun
     * @date: 2018/6/2 22:43
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("softInsert")
    @ResponseBody
    public Map<String, Object> softInsert(HttpSession session, CDSoftware cdSoftware) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            LOGGER.info("{}:开始安装软件：{}", session.getAttribute(HTTPSESSION_UID), BeanJsonUtil.bean2Json(cdSoftware));
            cdSoftware.setSoftCreaterId(Long.parseLong(session.getAttribute(HTTPSESSION_UID).toString()));
            int i = cdSoftwareService.insertSelective(cdSoftware);
            if (i == 1) {
                map.put("flag", true);
                map.put("msg", "操作成功");
            } else {
                map.put("flag", false);
                map.put("msg", "操作失败");
            }
            return map;
        } catch (Exception e) {
            LOGGER.error("{}:开始安装软件：{},失败：{}", session.getAttribute(HTTPSESSION_UID), BeanJsonUtil.bean2Json(cdSoftware), e);
            map.put("flag", false);
            map.put("msg", e);
            return map;
        }
    }

    @RequestMapping("updateSoft")
    @ResponseBody
    public Map<String, Object> updateSoft(CDSoftware cdSoftware) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int i = cdSoftwareService.updateByPrimaryKeySelective(cdSoftware);
            if (i == 1) {
                map.put("flag", true);
                map.put("msg", "操作成功");
            } else {
                map.put("flag", false);
                map.put("msg", "操作失败");
            }
            return map;
        } catch (Exception e) {
            LOGGER.error("更新软件：{},失败：{}",BeanJsonUtil.bean2Json(cdSoftware), e);
            map.put("flag", false);
            map.put("msg", e);
            return map;
        }
    }
}
