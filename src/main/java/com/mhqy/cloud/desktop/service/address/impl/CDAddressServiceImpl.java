package com.mhqy.cloud.desktop.service.address.impl;

import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.dao.CDAddressMapper.CDAddressMapper;
import com.mhqy.cloud.desktop.domin.CDAddress;
import com.mhqy.cloud.desktop.domin.WeatherDomin.CDWeather;
import com.mhqy.cloud.desktop.service.address.CDAddressService;
import com.mhqy.cloud.desktop.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description:地址
 * @author: peiqiankun
 * @date: 2018/3/31
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service
public class CDAddressServiceImpl implements CDAddressService {

    @Autowired
    private CDAddressMapper cdAddressMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private WeatherService weatherService;

    @Override
    public int deleteByPrimaryKey(Long addressId) {
        return cdAddressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public int insert(CDAddress record) {
        return cdAddressMapper.insert(record);
    }

    @Override
    public int insertSelective(CDAddress record) {
        return cdAddressMapper.insertSelective(record);
    }

    @Override
    public CDAddress selectByPrimaryKey(Long addressId) {
        return cdAddressMapper.selectByPrimaryKey(addressId);
    }

    @Override
    public int updateByPrimaryKeySelective(CDAddress record) {
        return cdAddressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CDAddress record) {
        return cdAddressMapper.updateByPrimaryKey(record);
    }

    /**
     * @Description:从redis里读取地址信息
     * @author: peiqiankun
     * @date: 2018/3/31 19:01
     * @mail: peiqiankun@jd.com
     */
    @Override
    public List<CDAddress> selectFromRedis() {
        Set<String> set = redisTemplate.keys("*");
        Iterator<String> it = set.iterator();
        CDAddress cdAddress = null;
        List<CDAddress> list = new ArrayList<>();
        while (it.hasNext()) {
            String url = it.next();
            cdAddress = new CDAddress();
            cdAddress.setAddressPlatId(Long.parseLong(url));
            CDWeather cdWeather = (CDWeather) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get(url).toString(), CDWeather.class);
            cdAddress.setAddressProvince(cdWeather.getProvince());
            cdAddress.setAddressCity(cdWeather.getCity());
            cdAddress.setCreateTime(new Date());
            cdAddress.setUpdateTime(new Date());
            list.add(cdAddress);
        }
        return list;
    }

    /**
     * @Description:随机读取20条数据
     * @author: peiqiankun
     * @date: 2018/3/31 20:27
     * @mail: peiqiankun@jd.com
     */
    @Override
    public List<CDAddress> selectByRand() {
        return cdAddressMapper.selectByRand();
    }

    /**
     * @Description:查询所有数据
     * @author: peiqiankun
     * @date: 2018/4/5 17:41
     * @mail: peiqiankun@jd.com
     */
    @Override
    public List<CDAddress> selectAllContent() {
        return cdAddressMapper.selectAllContent();
    }

    /**
     * @Description:根据城市查询ID
     * @author: peiqiankun
     * @date: 2018/6/13 16:10
     * @mail: peiqiankun@jd.com
     */
    @Override
    public List<CDAddress> listByProvince(String province) {
        CDAddress cdAddress = new CDAddress();
        cdAddress.setAddressProvince(province);
        return cdAddressMapper.selectByProvince(cdAddress);
    }
}
