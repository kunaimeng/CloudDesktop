package com.mhqy.cloud.desktop.dao.CDUserMapper;

import com.mhqy.cloud.desktop.domin.CDUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.dao
 * @ClassName: CDUserMapper
 * @Description:用户
 * @author: peiqiankun
 * @date: 2018-03-09 9:35
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Mapper
public interface CDUserMapper {

    int deleteByPrimaryKey(Long userId);

    int insert(CDUser record);

    int insertSelective(CDUser record);

    CDUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(CDUser record);

    int updateByPrimaryKey(CDUser record);
}
