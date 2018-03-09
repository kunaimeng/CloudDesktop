package com.mhqy.cloud.desktop.dao.CDFileMapper;

import com.mhqy.cloud.desktop.domin.CDFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CDFileMapper {
    int deleteByPrimaryKey(Long fileId);

    int insert(CDFile record);

    int insertSelective(CDFile record);

    CDFile selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(CDFile record);

    int updateByPrimaryKey(CDFile record);
}