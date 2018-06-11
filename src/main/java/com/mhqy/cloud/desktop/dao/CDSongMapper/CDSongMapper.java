package com.mhqy.cloud.desktop.dao.CDSongMapper;

import com.mhqy.cloud.desktop.domin.CDSong;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CDSongMapper {

    int deleteByPrimaryKey(Long songId);

    int insert(CDSong record);

    int insertSelective(CDSong record);

    CDSong selectByPrimaryKey(Long songId);

    int updateByPrimaryKeySelective(CDSong record);

    int updateByPrimaryKey(CDSong record);
}