package com.mhqy.cloud.desktop.service.song;

import com.mhqy.cloud.desktop.domin.CDMusician;

import java.util.List;

/**
 * @Description:音乐人
 * @author: peiqiankun
 * @date: 2018/6/10
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface CDMusicianService {

    int deleteByPrimaryKey(Long musicianId);

    int insert(CDMusician record);

    int insertSelective(CDMusician record);

    CDMusician selectByPrimaryKey(Long musicianId);

    int updateByPrimaryKeySelective(CDMusician record);

    int updateByPrimaryKey(CDMusician record);

    /**
     * @Description:删除所有数据
     * @author: peiqiankun
     * @date: 2018/6/11 18:12
     * @mail: peiqiankun@jd.com
     */
    void deleteAllData();

    /**
     * @Description:查询所有歌手信息
     * @author: peiqiankun
     * @date: 2018/6/11 18:53
     * @mail: peiqiankun@jd.com
     */
    List<CDMusician> selectAllData();
}
