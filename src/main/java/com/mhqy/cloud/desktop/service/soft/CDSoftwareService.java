package com.mhqy.cloud.desktop.service.soft;

import com.mhqy.cloud.desktop.domin.CDSoftware;

import java.util.List;

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

    /**
     * @Description:查询所有安装软件
     * @author: peiqiankun
     * @date: 2018/6/3 10:38
     * @mail: peiqiankun@jd.com
     */
    List<CDSoftware> listAllSoft();

}
