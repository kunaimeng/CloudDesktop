package com.mhqy.cloud.desktop.service.soft.impl;

import com.mhqy.cloud.desktop.dao.CDSoftwareMapper.CDSoftwareMapper;
import com.mhqy.cloud.desktop.domin.CDSoftware;
import com.mhqy.cloud.desktop.service.soft.CDSoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:软件相关
 * @author: peiqiankun
 * @date: 2018/6/2
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service
public class CDSoftwareServiceImpl implements CDSoftwareService {

    @Autowired
    private CDSoftwareMapper cdSoftwareMapper;

    @Override
    public int deleteByPrimaryKey(Long softId) {
        return cdSoftwareMapper.deleteByPrimaryKey(softId);
    }

    @Override
    public int insert(CDSoftware record) {
        return cdSoftwareMapper.insert(record);
    }

    @Override
    public int insertSelective(CDSoftware record) {
        return cdSoftwareMapper.insertSelective(record);
    }

    @Override
    public CDSoftware selectByPrimaryKey(Long softId) {
        return cdSoftwareMapper.selectByPrimaryKey(softId);
    }

    @Override
    public int updateByPrimaryKeySelective(CDSoftware record) {
        return cdSoftwareMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CDSoftware record) {
        return cdSoftwareMapper.updateByPrimaryKey(record);
    }
}
