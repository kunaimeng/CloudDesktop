package com.mhqy.cloud.desktop.domin;

import java.util.Date;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.domin
 * @ClassName: CDFile
 * @Description:文件实体类
 * @author: peiqiankun
 * @date: 2018-03-09 9:30
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class CDFile {
    
    private Long fileId;

    private Long fileUserId;

    private Long fileParentId;

    private String fileName;

    private Integer fileSize;

    private Double fileSimpleSize;

    private Integer fileType;

    private String fileExt;

    private Date createTime;

    private Date updateTime;

    private Byte yn;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getFileUserId() {
        return fileUserId;
    }

    public void setFileUserId(Long fileUserId) {
        this.fileUserId = fileUserId;
    }

    public Long getFileParentId() {
        return fileParentId;
    }

    public void setFileParentId(Long fileParentId) {
        this.fileParentId = fileParentId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Double getFileSimpleSize() {
        return fileSimpleSize;
    }

    public void setFileSimpleSize(Double fileSimpleSize) {
        this.fileSimpleSize = fileSimpleSize;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt == null ? null : fileExt.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getYn() {
        return yn;
    }

    public void setYn(Byte yn) {
        this.yn = yn;
    }
}
