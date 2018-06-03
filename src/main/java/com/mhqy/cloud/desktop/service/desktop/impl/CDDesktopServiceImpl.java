package com.mhqy.cloud.desktop.service.desktop.impl;

import com.mhqy.cloud.desktop.dao.CDDesktopMapper.CDDesktopMapper;
import com.mhqy.cloud.desktop.domin.CDDesktop;
import com.mhqy.cloud.desktop.service.desktop.CDDesktopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.service.CDDesktopService.Impl
 * @ClassName: CDDesktopServiceImpl
 * @Description:桌面service实现
 * @author: peiqiankun
 * @date: 2018-03-09 10:04
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service
public class CDDesktopServiceImpl implements CDDesktopService {

    @Autowired
    private CDDesktopMapper cdDesktopMapper;

    @Override
    public int deleteByPrimaryKey(Long desktopId) {
        return cdDesktopMapper.deleteByPrimaryKey(desktopId);
    }

    @Override
    public int insert(CDDesktop record) {
        return cdDesktopMapper.insert(record);
    }

    @Override
    public int insertSelective(CDDesktop record) {
        return cdDesktopMapper.insertSelective(record);
    }

    @Override
    public CDDesktop selectByPrimaryKey(Long desktopId) {
        return cdDesktopMapper.selectByPrimaryKey(desktopId);
    }

    @Override
    public int updateByPrimaryKeySelective(CDDesktop record) {
        return cdDesktopMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CDDesktop record) {
        return cdDesktopMapper.updateByPrimaryKey(record);
    }

    /**
     * @Description:基本搜索
     * @author: peiqiankun
     * @date: 2018/5/31 10:49
     * @mail: peiqiankun@jd.com
     */
    @Override
    public List<CDDesktop> listSoftWareByUserId(Long userID) {
        CDDesktop cdDesktop = new CDDesktop();
        cdDesktop.setDesktopUserId(userID);
        return cdDesktopMapper.selectByConditon(cdDesktop);
    }

    /**
     * @Description:删除软件
     * @author: peiqiankun
     * @date: 2018/6/3 18:59
     * @mail: peiqiankun@jd.com
     */
    @Override
    public int deleteSoft(CDDesktop record) {
        return cdDesktopMapper.deleteSoft(record);
    }
}
