package com.mhqy.cloud.desktop.service.CDAddressService;

import com.mhqy.cloud.desktop.domin.CDAddress;

import java.util.List;

/**
 * @Description:地址
 * @author: peiqiankun
 * @date: 2018/3/31
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface CDAddressService {

    int deleteByPrimaryKey(Long addressId);

    int insert(CDAddress record);

    int insertSelective(CDAddress record);

    CDAddress selectByPrimaryKey(Long addressId);

    int updateByPrimaryKeySelective(CDAddress record);

    int updateByPrimaryKey(CDAddress record);

    /**
     * @Description:从redis里读取地址信息
     * @author: peiqiankun
     * @date: 2018/3/31 19:01
     * @mail: peiqiankun@jd.com
     */
    List<CDAddress> selectFromRedis();

    /**
     * @Description:随机读取20条数据
     * @author: peiqiankun
     * @date: 2018/3/31 20:27
     * @mail: peiqiankun@jd.com
     */
    List<CDAddress> selectByRand();
}
