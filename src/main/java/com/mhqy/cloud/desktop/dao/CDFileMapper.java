package com.mhqy.cloud.desktop.dao;

import com.mhqy.cloud.desktop.domin.CDFile;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.dao
 * @ClassName: CDFileMapper
 * @Description:文件
 * @author: peiqiankun
 * @date: 2018-03-09 9:34
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface CDFileMapper {

    int deleteByPrimaryKey(Long fileId);

    int insert(CDFile record);

    int insertSelective(CDFile record);

    CDFile selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(CDFile record);

    int updateByPrimaryKey(CDFile record);
}
