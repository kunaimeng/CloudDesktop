package com.mhqy.cloud.desktop.domin;

import java.util.Date;

public class CDDesktop {
    private Long desktopId;

    private Long desktopUserId;

    private String desktopImg;

    private String desktopTitle;

    private String desktopDesc;

    private String desktopOpensrc;

    private Date createTime;

    private Date updateTime;

    private Byte yn;

    public Long getDesktopId() {
        return desktopId;
    }

    public void setDesktopId(Long desktopId) {
        this.desktopId = desktopId;
    }

    public Long getDesktopUserId() {
        return desktopUserId;
    }

    public void setDesktopUserId(Long desktopUserId) {
        this.desktopUserId = desktopUserId;
    }

    public String getDesktopImg() {
        return desktopImg;
    }

    public void setDesktopImg(String desktopImg) {
        this.desktopImg = desktopImg == null ? null : desktopImg.trim();
    }

    public String getDesktopTitle() {
        return desktopTitle;
    }

    public void setDesktopTitle(String desktopTitle) {
        this.desktopTitle = desktopTitle == null ? null : desktopTitle.trim();
    }

    public String getDesktopDesc() {
        return desktopDesc;
    }

    public void setDesktopDesc(String desktopDesc) {
        this.desktopDesc = desktopDesc == null ? null : desktopDesc.trim();
    }

    public String getDesktopOpensrc() {
        return desktopOpensrc;
    }

    public void setDesktopOpensrc(String desktopOpensrc) {
        this.desktopOpensrc = desktopOpensrc == null ? null : desktopOpensrc.trim();
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