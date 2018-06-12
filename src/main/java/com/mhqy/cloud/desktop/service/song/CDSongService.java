package com.mhqy.cloud.desktop.service.song;

import com.mhqy.cloud.desktop.domin.CDSong;

import java.util.List;

/**
 * @Description:音乐
 * @author: peiqiankun
 * @date: 2018/6/10
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface CDSongService {

    int deleteByPrimaryKey(Long songId);

    int insert(CDSong record);

    int insertSelective(CDSong record);

    CDSong selectByPrimaryKey(Long songId);

    int updateByPrimaryKeySelective(CDSong record);

    int updateByPrimaryKey(CDSong record);

    /**
     * @Description:查询歌曲相关信息
     * @author: peiqiankun
     * @date: 2018/6/12 16:15
     * @mail: peiqiankun@jd.com
     */
    List<CDSong> listByCondition(CDSong record);
}
