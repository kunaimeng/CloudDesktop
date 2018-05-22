package com.mhqy.cloud.desktop.dao.CDFileMapper;

import com.mhqy.cloud.desktop.domin.CDFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CDFileMapper {
    int deleteByPrimaryKey(Long fileId);

    int insert(CDFile record);

    int insertSelective(CDFile record);

    CDFile selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(CDFile record);

    int updateByPrimaryKey(CDFile record);

    List<CDFile> selectByFile(CDFile record);

    /**
     * @Description:根据用户查询相册信息
     * @author: peiqiankun
     * @date: 2018/5/20 20:53
     * @mail: peiqiankun@jd.com
     */
    List<CDFile> selectPhonoByUser(CDFile record);
    /**
     * @Description:查询音乐信息
     * @author: peiqiankun
     * @date: 2018/5/22 17:15
     * @mail: peiqiankun@jd.com
     */
    List<CDFile> selectMusic();

    /**
     * @Description:查询视频信息
     * @author: peiqiankun
     * @date: 2018/5/22 17:30
     * @mail: peiqiankun@jd.com
     */
    List<CDFile> selectMovie();
}