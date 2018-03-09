package com.mhqy.cloud.desktop.controller.DesktopController.FileController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:文件ajax请求
 * @author: peiqiankun
 * @date: 2018/3/3
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@RestController
public class FileRestController {

    @PostMapping("fileUpload")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        return null;
    }
}
