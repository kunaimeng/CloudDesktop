package com.mhqy.cloud.desktop.dao.CDDesktopMapper;

import com.mhqy.cloud.desktop.domin.CDDesktop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CDDesktopMapper {
    int deleteByPrimaryKey(Long desktopId);

    int insert(CDDesktop record);

    int insertSelective(CDDesktop record);

    CDDesktop selectByPrimaryKey(Long desktopId);

    int updateByPrimaryKeySelective(CDDesktop record);

    int updateByPrimaryKey(CDDesktop record);
}