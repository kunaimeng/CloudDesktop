package com.mhqy.cloud.desktop.domin;

import java.util.Date;

/**
 * @Description:文件实体
 * @author: peiqiankun
 * @date: 2018/3/9
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class CDFile {
    /**
     * 文件id
     */
    private Long fileId;
    /**
     * 所属者
     */
    private Long fileUserId;
    /**
     * 父目录
     */
    private Long fileParentId;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件唯一码
     */
    private String fileSystemName;
    /**
     * 字节大小
     */
    private String fileSize;
    /**
     * 多少兆
     */
    private String fileSimpleSize;
    /**
     * 1文件夹 2文件
     */
    private String fileType;
    /**
     * 文件后缀
     */
    private String fileExt;
    /**
     * 文件描述
     */
    private String fileDesc;

    /**
     * 引用次数
     */
    private Integer fileQuote;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除  1正常  2回收站  3已经删除
     */
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

    public String getFileSystemName() {
        return fileSystemName;
    }

    public void setFileSystemName(String fileSystemName) {
        this.fileSystemName = fileSystemName == null ? null : fileSystemName.trim();
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    public String getFileSimpleSize() {
        return fileSimpleSize;
    }

    public void setFileSimpleSize(String fileSimpleSize) {
        this.fileSimpleSize = fileSimpleSize == null ? null : fileSimpleSize.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt == null ? null : fileExt.trim();
    }

    public String getFileDesc() {
        return fileDesc;
    }

    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }

    public Integer getFileQuote() {
        return fileQuote;
    }

    public void setFileQuote(Integer fileQuote) {
        this.fileQuote = fileQuote;
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