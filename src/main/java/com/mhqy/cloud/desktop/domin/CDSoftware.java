package com.mhqy.cloud.desktop.domin;

import java.util.Date;

/**
 * @Description:软件相关实体
 * @author: peiqiankun
 * @date: 2018/6/2 20:30
 * @mail: peiqiankun@jd.com
 */
public class CDSoftware {
    /**
     * 软件ID
     */
    private Long softId;
    /**
     * 软件标题
     */
    private String softTitle;
    /**
     * 软件描述
     */
    private String softDesc;
    /**
     * 软件图片  图标
     */
    private String softImg;
    /**
     * 0图标 1图片
     */
    private Byte softImgType;
    /**
     * 打开路径
     */
    private String softUrl;
    /**
     * 0内部链接 1外部链接
     */
    private Byte softType;
    /**
     * 创建者ID
     */
    private Long softCreaterId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 1有效 0无效
     */
    private Byte yn;

    public Long getSoftId() {
        return softId;
    }

    public void setSoftId(Long softId) {
        this.softId = softId;
    }

    public String getSoftTitle() {
        return softTitle;
    }

    public void setSoftTitle(String softTitle) {
        this.softTitle = softTitle == null ? null : softTitle.trim();
    }

    public String getSoftDesc() {
        return softDesc;
    }

    public void setSoftDesc(String softDesc) {
        this.softDesc = softDesc == null ? null : softDesc.trim();
    }

    public String getSoftImg() {
        return softImg;
    }

    public void setSoftImg(String softImg) {
        this.softImg = softImg == null ? null : softImg.trim();
    }

    public Byte getSoftImgType() {
        return softImgType;
    }

    public void setSoftImgType(Byte softImgType) {
        this.softImgType = softImgType;
    }

    public String getSoftUrl() {
        return softUrl;
    }

    public void setSoftUrl(String softUrl) {
        this.softUrl = softUrl == null ? null : softUrl.trim();
    }

    public Byte getSoftType() {
        return softType;
    }

    public void setSoftType(Byte softType) {
        this.softType = softType;
    }

    public Long getSoftCreaterId() {
        return softCreaterId;
    }

    public void setSoftCreaterId(Long softCreaterId) {
        this.softCreaterId = softCreaterId;
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