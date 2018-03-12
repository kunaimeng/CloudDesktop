package com.mhqy.cloud.desktop.domin;

import java.io.Serializable;
import java.util.Date;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.domin
 * @ClassName: CDSocketMessage
 * @Description:消息实体
 * @author: peiqiankun
 * @date: 2018-03-12 9:44
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class CDSocketMessage {
    /*状态码*/
    private String code;
    /*发送者*/
    private String From;
    /*接受者*/
    private String To;
    /*消息*/
    private String message;
    /*数据*/
    private Object data;
    /*时间*/
    private Date date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
