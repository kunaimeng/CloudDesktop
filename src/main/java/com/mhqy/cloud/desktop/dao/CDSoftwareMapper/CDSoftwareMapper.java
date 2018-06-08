package com.mhqy.cloud.desktop.dao.CDSoftwareMapper;

import com.mhqy.cloud.desktop.domin.CDSoftware;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CDSoftwareMapper {
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
    List<CDSoftware> selectAllSoft(CDSoftware record);

}