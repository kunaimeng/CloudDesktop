package com.mhqy.cloud.desktop.service.soft;

import com.mhqy.cloud.desktop.domin.CDSoftware;

/**
 * @Description:软件相关
 * @author: peiqiankun
 * @date: 2018/6/2
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface CDSoftwareService {

    int deleteByPrimaryKey(Long softId);

    int insert(CDSoftware record);

    int insertSelective(CDSoftware record);

    CDSoftware selectByPrimaryKey(Long softId);

    int updateByPrimaryKeySelective(CDSoftware record);

    int updateByPrimaryKey(CDSoftware record);

}
