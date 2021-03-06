package com.mhqy.cloud.desktop.service.file;

import com.mhqy.cloud.desktop.domin.CDFile;

import java.util.List;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.service
 * @ClassName: CDFileService
 * @Description:文件
 * @author: peiqiankun
 * @date: 2018-03-09 9:34
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface CDFileService {

    int deleteByPrimaryKey(Long fileId);

    int insert(CDFile record);

    int insertSelective(CDFile record);

    CDFile selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(CDFile record);

    int updateByPrimaryKey(CDFile record);

    List<CDFile> selectByFile(CDFile record);

    /**
     * @Description:根据用户查询相册信息
     * @author: peiqiankun
     * @date: 2018/5/20 20:53
     * @mail: peiqiankun@jd.com
     */
    List<CDFile> listPhonoByUser(CDFile record);

    /**
     * @Description:查询音乐信息
     * @author: peiqiankun
     * @date: 2018/5/22 17:15
     * @mail: peiqiankun@jd.com
     */
    List<CDFile> listMusic();

    /**
     * @Description:查询视频信息
     * @author: peiqiankun
     * @date: 2018/5/22 17:30
     * @mail: peiqiankun@jd.com
     */
    List<CDFile> listMovie();

}
