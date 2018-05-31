package com.mhqy.cloud.desktop.domin;

import java.util.Date;

/**
 * @Description:桌面实体
 * @author: peiqiankun
 * @date: 2018/3/9
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class CDDesktop {
    /**
     * 桌面id
     */
    private Long desktopId;
    /**
     * 所属者
     */
    private Long desktopUserId;
    /**
     * 桌面图标
     */
    private String desktopImg;
    /**
     * 桌面图标名称
     */
    private String desktopTitle;
    /**
     * 描述
     */
    private String desktopDesc;
    /**
     * 打开的路径
     */
    private String desktopOpensrc;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 1 有效  2已删除
     */
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