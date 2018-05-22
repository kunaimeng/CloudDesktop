package com.mhqy.cloud.desktop.controller.desktop.FileController;

import com.mhqy.cloud.desktop.service.fileupload.FileUploadService;
import com.mhqy.cloud.desktop.domin.CDFile;
import com.mhqy.cloud.desktop.service.file.CDFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:文件ajax请求
 * @author: peiqiankun
 * @date: 2018/3/3
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@RestController
public class FileRestController {

    private final static Logger logger = LoggerFactory.getLogger(FileRestController.class);

    @Autowired
    private CDFileService cdFileService;

    @Autowired
    private FileUploadService fileUploadService;

    /**
     * @Description:文件上传
     * @author: peiqiankun
     * @date: 2018/5/21 15:36
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("fileUpload")
    public CDFile upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpSession session) {
        CDFile cdFile = fileUploadService.upload(file, request);
        cdFile.setFileUserId(Long.parseLong(session.getAttribute("Uid").toString()));
        cdFileService.insert(cdFile);
        return cdFile;
    }

    /**
     * @Description:查询文件信息
     * @author: peiqiankun
     * @date: 2018/5/21 15:36
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("queryFileList")
    public Map<String,Object> queryFileList(CDFile cdFile){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            cdFile.setYn(new Byte("1"));
            List<CDFile> list = cdFileService.selectByFile(cdFile);
            map.put("flag",true);
            map.put("list",list);
            return map;
        }catch (Exception e){
            logger.error("获取文件数据异常-->",e.getMessage());
            map.put("flag",false);
            map.put("msg",e.getMessage());
            return map;
        }
    }

    /**
     * @Description:更新文件信息
     * @author: peiqiankun
     * @date: 2018/5/21 15:35
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("updateFile")
    public Map<String, Object> updateFile(CDFile cdFile) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int i = cdFileService.updateByPrimaryKeySelective(cdFile);
            if (i == 1) {
                map.put("msg", "操作成功");
            } else {
                map.put("msg", "操作失败");
            }
            map.put("flag", true);
            return map;
        } catch (Exception e) {
            logger.error("更新文件数据异常-->", e.getMessage());
            map.put("flag", false);
            map.put("msg", e.getMessage());
            return map;
        }
    }

    /**
     * @Description:新建文件夹
     * @author: peiqiankun
     * @date: 2018/5/22 10:25
     * @mail: peiqiankun@jd.com
     */
    @RequestMapping("newBuildFolder")
    public Map<String, Object> newBuildFolder(CDFile cdFile,HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            cdFile.setFileUserId(Long.parseLong(session.getAttribute("Uid").toString()));
            cdFile.setYn(new Byte("1"));
            cdFile.setFileType("1");
            cdFile.setCreateTime(new Date());
            cdFile.setCreateTime(new Date());
            int i = cdFileService.insertSelective(cdFile);
            if (i == 1) {
                map.put("msg", "操作成功");
            } else {
                map.put("msg", "操作失败");
            }
            map.put("flag", true);
            return map;
        } catch (Exception e) {
            logger.error("新建文件夹异常-->", e.getMessage());
            map.put("flag", false);
            map.put("msg", e.getMessage());
            return map;
        }
    }
}
