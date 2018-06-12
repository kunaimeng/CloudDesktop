package com.mhqy.cloud.desktop.service.song.impl;

import com.mhqy.cloud.desktop.dao.CDSongMapper.CDSongMapper;
import com.mhqy.cloud.desktop.domin.CDSong;
import com.mhqy.cloud.desktop.service.song.CDSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:音乐服务层
 * @author: peiqiankun
 * @date: 2018/6/11
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service
public class CDSongServiceImpl implements CDSongService{

    @Autowired
    private CDSongMapper cdSongMapper;

    @Override
    public int deleteByPrimaryKey(Long songId) {
        return cdSongMapper.deleteByPrimaryKey(songId);
    }

    @Override
    public int insert(CDSong record) {
        return cdSongMapper.insert(record);
    }

    @Override
    public int insertSelective(CDSong record) {
        return cdSongMapper.insertSelective(record);
    }

    @Override
    public CDSong selectByPrimaryKey(Long songId) {
        return cdSongMapper.selectByPrimaryKey(songId);
    }

    @Override
    public int updateByPrimaryKeySelective(CDSong record) {
        return cdSongMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CDSong record) {
        return cdSongMapper.updateByPrimaryKey(record);
    }

    /**
     * @Description:查询歌曲相关信息
     * @author: peiqiankun
     * @date: 2018/6/12 16:15
     * @mail: peiqiankun@jd.com
     */
    @Override
    public List<CDSong> listByCondition(CDSong record){
        return cdSongMapper.selectByCondition(record);
    }
}
