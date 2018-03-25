package com.mhqy.cloud.desktop.domin.WeatherDomin;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/3/25
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class Weather {
    /*日期*/
    private String date;
    /*周几*/
    private String week;
    /*天气描述*/
    private String weatherDesc;
    /*最高气温*/
    private String maxTemp;
    /*最低气温*/
    private String minTemp;
    /*风向开始*/
    private String windFrom;
    /*风向结束*/
    private String winTo;
    /*风速*/
    private String windSpeed;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getWindFrom() {
        return windFrom;
    }

    public void setWindFrom(String windFrom) {
        this.windFrom = windFrom;
    }

    public String getWinTo() {
        return winTo;
    }

    public void setWinTo(String winTo) {
        this.winTo = winTo;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
