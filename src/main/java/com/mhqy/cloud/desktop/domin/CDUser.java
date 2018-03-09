package com.mhqy.cloud.desktop.domin;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:用户实体
 * @author: peiqiankun
 * @date: 2018/3/9
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class CDUser {
    /*主键*/
    private Long userId;
    /*用户名*/
    private String userName;
    /*用户手机号*/
    private String userPhone;
    /*用户qq*/
    private String userQq;
    /*用户微信*/
    private String userWx;
    /*用户密码*/
    private String userPassword;
    /*用户头像*/
    private String userImg;
    /*出生日期*/
    private Date userBirthday;
    /*年龄*/
    private Integer userAge;
    /*用户住址*/
    private String userAddress;
    /*经度*/
    private BigDecimal userLongitude;
    /*纬度*/
    private BigDecimal userLatitude;
    /*创建日期*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;
    /*是否有效*/
    private Byte yn;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    public String getUserWx() {
        return userWx;
    }

    public void setUserWx(String userWx) {
        this.userWx = userWx == null ? null : userWx.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public BigDecimal getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(BigDecimal userLongitude) {
        this.userLongitude = userLongitude;
    }

    public BigDecimal getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(BigDecimal userLatitude) {
        this.userLatitude = userLatitude;
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