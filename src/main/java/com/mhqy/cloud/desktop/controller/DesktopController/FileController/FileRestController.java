package com.mhqy.cloud.desktop.controller.DesktopController.FileController;

import com.mhqy.cloud.desktop.common.FileUpload;
import com.mhqy.cloud.desktop.domin.CDFile;
import com.mhqy.cloud.desktop.service.CDFileService.CDFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description:文件ajax请求
 * @author: peiqiankun
 * @date: 2018/3/3
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@RestController
public class FileRestController {

    @Autowired
    private CDFileService cdFileService;

    @RequestMapping("fileUpload")
    public CDFile upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpSession session) {
        CDFile cdFile = FileUpload.upload(file, request);
        cdFile.setFileUserId(Long.parseLong(session.getAttribute("Uid").toString()));
        cdFileService.insert(cdFile);
        return cdFile;
    }
}
