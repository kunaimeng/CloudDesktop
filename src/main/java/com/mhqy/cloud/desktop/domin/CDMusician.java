package com.mhqy.cloud.desktop.domin;

import java.util.Date;

/**
 * @Description:音乐人
 * @author: peiqiankun
 * @date: 2018/6/11 16:37
 * @mail: peiqiankun@jd.com
 */
public class CDMusician {
    /**
     * 音乐id
     */
    private Long musicianId;
    /**
     * 音乐id
     */
    private String musicianName;
    /**
     * 百度音乐人id
     */
    private Long musicianBdId;
    /**
     * 音乐人简介
     */
    private String musicianIntroduction;
    /**
     * 音乐人头像
     */
    private String musicianBdImg;
    /**
     * 音乐人生辰
     */
    private String musicianBirth;
    /**
     * 音乐人地址
     */
    private String musicianAddress;
    /**
     * 热度
     */
    private String musicianHot;
    /**
     * 创建是啊金
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否有效
     */
    private Byte yn;

    public Long getMusicianId() {
        return musicianId;
    }

    public void setMusicianId(Long musicianId) {
        this.musicianId = musicianId;
    }

    public String getMusicianName() {
        return musicianName;
    }

    public void setMusicianName(String musicianName) {
        this.musicianName = musicianName == null ? null : musicianName.trim();
    }

    public Long getMusicianBdId() {
        return musicianBdId;
    }

    public void setMusicianBdId(Long musicianBdId) {
        this.musicianBdId = musicianBdId;
    }

    public String getMusicianIntroduction() {
        return musicianIntroduction;
    }

    public void setMusicianIntroduction(String musicianIntroduction) {
        this.musicianIntroduction = musicianIntroduction == null ? null : musicianIntroduction.trim();
    }

    public String getMusicianBdImg() {
        return musicianBdImg;
    }

    public void setMusicianBdImg(String musicianBdImg) {
        this.musicianBdImg = musicianBdImg == null ? null : musicianBdImg.trim();
    }

    public String getMusicianBirth() {
        return musicianBirth;
    }

    public void setMusicianBirth(String musicianBirth) {
        this.musicianBirth = musicianBirth == null ? null : musicianBirth.trim();
    }

    public String getMusicianAddress() {
        return musicianAddress;
    }

    public void setMusicianAddress(String musicianAddress) {
        this.musicianAddress = musicianAddress == null ? null : musicianAddress.trim();
    }

    public String getMusicianHot() {
        return musicianHot;
    }

    public void setMusicianHot(String musicianHot) {
        this.musicianHot = musicianHot == null ? null : musicianHot.trim();
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