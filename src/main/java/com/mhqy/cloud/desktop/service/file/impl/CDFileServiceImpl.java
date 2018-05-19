package com.mhqy.cloud.desktop.service.file.impl;

import com.mhqy.cloud.desktop.dao.CDFileMapper.CDFileMapper;
import com.mhqy.cloud.desktop.domin.CDFile;
import com.mhqy.cloud.desktop.service.file.CDFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.service.CDFileService.Impl
 * @ClassName: CDFileServiceImpl
 * @Description:文件service实现
 * @author: peiqiankun
 * @date: 2018-03-09 10:05
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service
public class CDFileServiceImpl implements CDFileService {

    @Autowired
    private CDFileMapper cdFileMapper;

    @Override
    public int deleteByPrimaryKey(Long fileId) {
        return cdFileMapper.deleteByPrimaryKey(fileId);
    }

    @Override
    public int insert(CDFile record) {
        return cdFileMapper.insert(record);
    }

    @Override
    public int insertSelective(CDFile record) {
        return cdFileMapper.insertSelective(record);
    }

    @Override
    public CDFile selectByPrimaryKey(Long fileId) {
        return cdFileMapper.selectByPrimaryKey(fileId);
    }

    @Override
    public int updateByPrimaryKeySelective(CDFile record) {
        return cdFileMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CDFile record) {
        return cdFileMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CDFile> selectByFile(CDFile record){
        return cdFileMapper.selectByFile(record);
    }
}
