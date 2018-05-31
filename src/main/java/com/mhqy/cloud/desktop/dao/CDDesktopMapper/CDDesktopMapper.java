package com.mhqy.cloud.desktop.dao.CDDesktopMapper;

import com.mhqy.cloud.desktop.domin.CDDesktop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CDDesktopMapper {
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
    List<CDDesktop> selectByConditon(CDDesktop record);
}