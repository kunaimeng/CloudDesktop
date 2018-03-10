package com.mhqy.cloud.desktop.service.CDUserService.Impl;

import com.mhqy.cloud.desktop.common.ListUtil;
import com.mhqy.cloud.desktop.dao.CDUserMapper.CDUserMapper;
import com.mhqy.cloud.desktop.domin.CDUser;
import com.mhqy.cloud.desktop.service.CDUserService.CDUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.service.CDUserService
 * @ClassName: CDUserServiceImpl
 * @Description:用户service实现
 * @author: peiqiankun
 * @date: 2018-03-09 10:05
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service
public class CDUserServiceImpl implements CDUserService {

    @Autowired
    private CDUserMapper cdUserMapper;

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return cdUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(CDUser record) {
        return cdUserMapper.insert(record);
    }

    @Override
    public int insertSelective(CDUser record) {
        return cdUserMapper.insertSelective(record);
    }

    @Override
    public CDUser selectByPrimaryKey(Long userId) {
        return cdUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(CDUser record) {
        return cdUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CDUser record) {
        return cdUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CDUser> selectByCDUser(CDUser record){
        return cdUserMapper.selectByCDUser(record);
    }

    @Override
    public Map<String,Object> userLogin(CDUser record){
        Map<String,Object> map = new HashMap<String,Object>();
        Assert.notNull(record.getUserPhone(),"用户名不能为空！");
        Assert.notNull(record.getUserPassword(),"密码不能为空！");
        List<CDUser> list = selectByCDUser(record);
        if(ListUtil.isNotEmpty(list)){
            map.put("Uid",list.get(0).getUserId());
            map.put("flag",true);
        }else{
            map.put("flag",false);
        }
        return map;
    }
}
