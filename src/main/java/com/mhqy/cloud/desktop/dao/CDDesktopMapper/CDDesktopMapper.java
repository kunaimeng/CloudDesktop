package com.mhqy.cloud.desktop.dao.CDDesktopMapper;

import com.mhqy.cloud.desktop.domin.CDDesktop;
import org.apache.ibatis.annotations.Mapper;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.dao
 * @ClassName: CDDesktopMapper
 * @Description:桌面
 * @author: peiqiankun
 * @date: 2018-03-09 9:33
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Mapper
public interface CDDesktopMapper {

    int deleteByPrimaryKey(Long desktopId);

    int insert(CDDesktop record);

    int insertSelective(CDDesktop record);

    CDDesktop selectByPrimaryKey(Long desktopId);

    int updateByPrimaryKeySelective(CDDesktop record);

    int updateByPrimaryKey(CDDesktop record);
}
