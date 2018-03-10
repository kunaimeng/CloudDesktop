package com.mhqy.cloud.desktop.service.CDUserService;

import com.mhqy.cloud.desktop.domin.CDUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.service
 * @ClassName: CDUserService
 * @Description:用户
 * @author: peiqiankun
 * @date: 2018-03-09 9:35
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface CDUserService {

    int deleteByPrimaryKey(Long userId);

    int insert(CDUser record);

    int insertSelective(CDUser record);

    CDUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(CDUser record);

    int updateByPrimaryKey(CDUser record);

    List<CDUser> selectByCDUser(CDUser record);

    Map<String,Object> userLogin(CDUser record);
}
