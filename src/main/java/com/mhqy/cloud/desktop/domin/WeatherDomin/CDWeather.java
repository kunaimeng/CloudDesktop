package com.mhqy.cloud.desktop.domin.WeatherDomin;

import java.util.List;

/**
 * @Description:天气实体类
 * @author: peiqiankun
 * @date: 2018/3/25
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class CDWeather {
    /*地区id*/
    private String addressId;
    /*更新时间*/
    private String updateTime;
    /*省*/
    private String province;
    /*市*/
    private String city;
    /*天气*/
    private List<Weather> weathers;
    /*来源*/
    private String from;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
