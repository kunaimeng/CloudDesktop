package com.mhqy.cloud.desktop.common;

import com.mhqy.cloud.desktop.controller.BaseController;
import com.mhqy.cloud.desktop.domin.CDFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.common
 * @ClassName: FileUpload
 * @Description:文件上传
 * @author: peiqiankun
 * @date: 2018-03-09 14:23
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class FileUpload {

    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    public static CDFile upload(MultipartFile file, HttpServletRequest request) {
        CDFile cdFile = new CDFile();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/") + "\\" + "upload\\";
            File dirPath = new File(realPath);
            //自动创建上传的upload目录
            if (!dirPath.exists()) dirPath.mkdirs();
            String oldName = file.getOriginalFilename();
            String newName = FileUtil.generateFileName(oldName, 5, "yyyyMMddHHmmss");
            File targetFile = new File(dirPath, newName);
            file.transferTo(targetFile);//文件上传
            cdFile.setFileExt(FileUtil.getExtNoPoint(oldName));
            cdFile.setFileName(oldName);
            cdFile.setFileSystemName(newName);
            cdFile.setFileSize(Long.toString(file.getSize()));
            cdFile.setFileType("2");
            cdFile.setFileParentId(0L);
            cdFile.setYn(new Byte("1"));
            cdFile.setFileUserId(0L);
            cdFile.setFileSimpleSize(FileUtil.countFileSize(file.getSize()));
        } catch (Exception e) {
            logger.error("文件上传失败-->{}", e.getMessage());
        }
        return cdFile;
    }
}
