package com.mhqy.cloud.desktop.dao.CDAddressMapper;

import com.mhqy.cloud.desktop.domin.CDAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CDAddressMapper {

    int deleteByPrimaryKey(Long addressId);

    int insert(CDAddress record);

    int insertSelective(CDAddress record);

    CDAddress selectByPrimaryKey(Long addressId);

    int updateByPrimaryKeySelective(CDAddress record);

    int updateByPrimaryKey(CDAddress record);

    /**
     * @Description:随机读取20条数据
     * @author: peiqiankun
     * @date: 2018/3/31 20:27
     * @mail: peiqiankun@jd.com
     */
    List<CDAddress> selectByRand();

    /**
     * @Description:查询所有数据
     * @author: peiqiankun
     * @date: 2018/4/5 17:41
     * @mail: peiqiankun@jd.com
     */
    List<CDAddress> selectAllContent();

    /**
     * @Description:根据城市查询相关ID
     * @author: peiqiankun
     * @date: 2018/6/13 16:09
     * @mail: peiqiankun@jd.com
     */
    List<CDAddress> selectByProvince(CDAddress record);
}