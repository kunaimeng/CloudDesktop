package com.mhqy.cloud.desktop.dao.CDSoftwareMapper;

import com.mhqy.cloud.desktop.domin.CDSoftware;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CDSoftwareMapper {
    int deleteByPrimaryKey(Long softId);

    int insert(CDSoftware record);

    int insertSelective(CDSoftware record);

    CDSoftware selectByPrimaryKey(Long softId);

    int updateByPrimaryKeySelective(CDSoftware record);

    int updateByPrimaryKey(CDSoftware record);
}