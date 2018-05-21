package com.mhqy.cloud.desktop.service.fileupload;

import com.mhqy.cloud.desktop.domin.CDFile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/5/21
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface FileUploadService {

    /**
     * @Description:文件上传
     * @author: peiqiankun
     * @date: 2018/5/21 14:30
     * @mail: peiqiankun@jd.com
     */
    CDFile upload(MultipartFile file, HttpServletRequest request);

}
