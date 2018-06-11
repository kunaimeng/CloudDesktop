package com.mhqy.cloud.desktop.domin;

import java.util.Date;

/**
 * @Description:音乐实体
 * @author: peiqiankun
 * @date: 2018/6/10 22:47
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
    private String songBdId;
    /**
     * 音乐歌词路径
     */
    private String songLrcSrc;
    /**
     * 音乐路径
     */
    private String songMp3Src;
    /**
     * 音乐人ID
     */
    private Long songMusicianId;
    /**
     * 音乐背景图小号
     */
    private String songBgSm;
    /**
     * 音乐背景图中号
     */
    private String songBgLg;
    /**
     * 音乐背景图大号
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

    public String getSongBdId() {
        return songBdId;
    }

    public void setSongBdId(String songBdId) {
        this.songBdId = songBdId == null ? null : songBdId.trim();
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

    public Long getSongMusicianId() {
        return songMusicianId;
    }

    public void setSongMusicianId(Long songMusicianId) {
        this.songMusicianId = songMusicianId;
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