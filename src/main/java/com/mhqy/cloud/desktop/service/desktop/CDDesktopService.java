package com.mhqy.cloud.desktop.service.desktop;

import com.mhqy.cloud.desktop.domin.CDDesktop;

import java.util.List;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.service
 * @ClassName: CDDesktopService
 * @Description:桌面
 * @author: peiqiankun
 * @date: 2018-03-09 9:33
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface CDDesktopService {

    int deleteByPrimaryKey(Long desktopId);

    int insert(CDDesktop record);

    int insertSelective(CDDesktop record);

    CDDesktop selectByPrimaryKey(Long desktopId);

    int updateByPrimaryKeySelective(CDDesktop record);

    int updateByPrimaryKey(CDDesktop record);

    /**
     * @Description:基本搜索
     * @author: peiqiankun
     * @date: 2018/5/31 10:49
     * @mail: peiqiankun@jd.com
     */
    List<CDDesktop> listSoftWareByUserId(Long userID);
}
