package com.mhqy.cloud.desktop.service.CDFileService;

import com.mhqy.cloud.desktop.domin.CDFile;
import org.apache.ibatis.annotations.Mapper;

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

}
