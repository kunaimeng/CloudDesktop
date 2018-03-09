package com.mhqy.cloud.desktop.dao.CDUserMapper;

import com.mhqy.cloud.desktop.domin.CDUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CDUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(CDUser record);

    int insertSelective(CDUser record);

    CDUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(CDUser record);

    int updateByPrimaryKey(CDUser record);
}