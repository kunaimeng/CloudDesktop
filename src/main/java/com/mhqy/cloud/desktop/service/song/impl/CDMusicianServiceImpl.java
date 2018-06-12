package com.mhqy.cloud.desktop.service.song.impl;

import com.mhqy.cloud.desktop.dao.CDMusicianMapper.CDMusicianMapper;
import com.mhqy.cloud.desktop.domin.CDMusician;
import com.mhqy.cloud.desktop.service.song.CDMusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:音乐人服务层
 * @author: peiqiankun
 * @date: 2018/6/11
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service
public class CDMusicianServiceImpl implements CDMusicianService {

    @Autowired
    private CDMusicianMapper cdMusicianMapper;

    @Override
    public int deleteByPrimaryKey(Long musicianId) {
        return cdMusicianMapper.deleteByPrimaryKey(musicianId);
    }

    @Override
    public int insert(CDMusician record) {
        return cdMusicianMapper.insert(record);
    }

    @Override
    public int insertSelective(CDMusician record) {
        return cdMusicianMapper.insertSelective(record);
    }

    @Override
    public CDMusician selectByPrimaryKey(Long musicianId) {
        return cdMusicianMapper.selectByPrimaryKey(musicianId);
    }

    @Override
    public int updateByPrimaryKeySelective(CDMusician record) {
        return cdMusicianMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CDMusician record) {
        return cdMusicianMapper.updateByPrimaryKey(record);
    }

    /**
     * @Description:删除所有数据
     * @author: peiqiankun
     * @date: 2018/6/11 18:12
     * @mail: peiqiankun@jd.com
     */
    @Override
    public void deleteAllData() {
        cdMusicianMapper.deleteAllData();
    }

    /**
     * @Description:查询所有歌手信息
     * @author: peiqiankun
     * @date: 2018/6/11 18:54
     * @mail: peiqiankun@jd.com
     */
    @Override
    public List<CDMusician> selectAllData() {
        return cdMusicianMapper.selectAllData();
    }

    /**
     * @Description:搜索歌手信息
     * @author: peiqiankun
     * @date: 2018/6/12 16:18
     * @mail: peiqiankun@jd.com
     */
    @Override
    public List<CDMusician> listByCondition(CDMusician record){
        return cdMusicianMapper.selectByCondition(record);
    }
}
