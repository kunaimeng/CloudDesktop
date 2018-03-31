package com.mhqy.cloud.desktop.domin;

import java.util.Date;

/**
 * @Description:地址
 * @author: peiqiankun
 * @date: 2018/3/31 19:45
 * @mail: peiqiankun@jd.com
 */
public class CDAddress {
    /*主键*/
    private Long addressId;
    /*地址编号*/
    private Long addressPlatId;
    /*省*/
    private String addressProvince;
    /*市*/
    private String addressCity;
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;
    /*是否有效*/
    private Byte yn;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getAddressPlatId() {
        return addressPlatId;
    }

    public void setAddressPlatId(Long addressPlatId) {
        this.addressPlatId = addressPlatId;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince == null ? null : addressProvince.trim();
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
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