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

    @RequestMapping("fileUpload")
    public CDFile upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpSession session) {
        CDFile cdFile = fileUploadService.upload(file, request);
        cdFile.setFileUserId(Long.parseLong(session.getAttribute("Uid").toString()));
        cdFileService.insert(cdFile);
        return cdFile;
    }

    @RequestMapping("queryFileList")
    public Map<String,Object> queryFileList(CDFile cdFile){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            cdFile.setYn(new Byte("1"));
            List<CDFile> list = cdFileService.selectByFile(cdFile);
            map.put("flag",true);
            map.put("list",list);
        }catch (Exception e){
            logger.error("删除文件数据异常-->",e.getMessage());
            map.put("flag",false);
            map.put("msg",e.getMessage());
        }finally {
            return map;
        }
    }

    @RequestMapping("updateFile")
    public Map<String,Object> updateFile(CDFile cdFile){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            int i = cdFileService.updateByPrimaryKeySelective(cdFile);
            if(i==1){
                map.put("msg","删除成功");
            }else{
                map.put("msg","删除失败");
            }
            map.put("flag",true);
        }catch (Exception e){
            logger.error("获取文件数据异常-->",e.getMessage());
            map.put("flag",false);
            map.put("msg",e.getMessage());
        }finally {
            return map;
        }
    }
}
