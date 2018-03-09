package com.mhqy.cloud.desktop.domin;

import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.domin
 * @ClassName: CDDesktop
 * @Description:桌面实体类
 * @author: peiqiankun
 * @date: 2018-03-09 9:29
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
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
