package com.mhqy.cloud.desktop.domin;

import java.util.Date;

/**
 * @Description:音乐
 * @author: peiqiankun
 * @date: 2018/6/11 21:24
 * @mail: peiqiankun@jd.com
 */
public class CDSong {
    /**
     * 音乐id
     */
    private Long songId;
    /**
     * 音乐百度id
     */
    private Long songBdId;
    /**
     * 音乐id
     */
    private Long songMusicianId;
    /**
     * 音乐名称
     */
    private String songName;
    /**
     * 音乐歌词路径
     */
    private String songLrcSrc;
    /**
     * 音乐路径
     */
    private String songMp3Src;
    /**
     * 音乐专辑
     */
    private String songAlbum;
    /**
     * 音乐时长
     */
    private String songLongTime;
    /**
     * 音乐小头像
     */
    private String songBgSm;
    /**
     * 音乐中头像
     */
    private String songBgLg;
    /**
     * 音乐大头像
     */
    private String songBgBg;
    /**
     * 音乐大小
     */
    private Integer songSize;
    /**
     * 创建时间
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

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getSongBdId() {
        return songBdId;
    }

    public void setSongBdId(Long songBdId) {
        this.songBdId = songBdId;
    }

    public Long getSongMusicianId() {
        return songMusicianId;
    }

    public void setSongMusicianId(Long songMusicianId) {
        this.songMusicianId = songMusicianId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName == null ? null : songName.trim();
    }

    public String getSongLrcSrc() {
        return songLrcSrc;
    }

    public void setSongLrcSrc(String songLrcSrc) {
        this.songLrcSrc = songLrcSrc == null ? null : songLrcSrc.trim();
    }

    public String getSongMp3Src() {
        return songMp3Src;
    }

    public void setSongMp3Src(String songMp3Src) {
        this.songMp3Src = songMp3Src == null ? null : songMp3Src.trim();
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum == null ? null : songAlbum.trim();
    }

    public String getSongLongTime() {
        return songLongTime;
    }

    public void setSongLongTime(String songLongTime) {
        this.songLongTime = songLongTime == null ? null : songLongTime.trim();
    }

    public String getSongBgSm() {
        return songBgSm;
    }

    public void setSongBgSm(String songBgSm) {
        this.songBgSm = songBgSm == null ? null : songBgSm.trim();
    }

    public String getSongBgLg() {
        return songBgLg;
    }

    public void setSongBgLg(String songBgLg) {
        this.songBgLg = songBgLg == null ? null : songBgLg.trim();
    }

    public String getSongBgBg() {
        return songBgBg;
    }

    public void setSongBgBg(String songBgBg) {
        this.songBgBg = songBgBg == null ? null : songBgBg.trim();
    }

    public Integer getSongSize() {
        return songSize;
    }

    public void setSongSize(Integer songSize) {
        this.songSize = songSize;
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