package com.mhqy.cloud.desktop.service.fileupload.impl;

import com.mhqy.cloud.desktop.service.fileupload.FileUploadService;
import com.mhqy.cloud.desktop.common.util.FileUtil;
import com.mhqy.cloud.desktop.domin.CDFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/5/21
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final static Logger LOGGER = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    @Value("${file.upload.path}")
    private String File_UPLOAN_PATH;

    @Override
    public CDFile upload(MultipartFile file, HttpServletRequest request) {
        CDFile cdFile = new CDFile();
        try {
            File dirPath = new File(File_UPLOAN_PATH);
            //自动创建上传的upload目录
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
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
            cdFile.setCreateTime(new Date());
            cdFile.setUpdateTime(new Date());
            cdFile.setFileSimpleSize(FileUtil.countFileSize(file.getSize()));
        } catch (Exception e) {
            LOGGER.error("文件上传失败-->{}", e);
        }
        return cdFile;
    }
}
