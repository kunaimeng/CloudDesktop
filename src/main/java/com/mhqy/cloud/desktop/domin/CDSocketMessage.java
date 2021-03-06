package com.mhqy.cloud.desktop.domin;


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
    /**
     * 状态码
     */
    private String code;
    /**
     * 发送者
     */
    private CDUser from;
    /**
     * 接受者
     */
    private CDUser To;
    /**
     * 发送者 session
     */
    private String sessionFrom;
    /**
     * 接受者 session
     */
    private String sessionTo;
    /**
     * 标题
     */
    private String title;
    /**
     * 消息
     */
    private String message;
    /**
     * 在线数
     */
    private Integer onLineCount;
    /**
     * 数据
     */
    private Object data;
    /**
     * 时间
     */
    private Date date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CDUser getFrom() {
        return from;
    }

    public void setFrom(CDUser from) {
        this.from = from;
    }

    public CDUser getTo() {
        return To;
    }

    public void setTo(CDUser to) {
        To = to;
    }

    public String getSessionFrom() {
        return sessionFrom;
    }

    public void setSessionFrom(String sessionFrom) {
        this.sessionFrom = sessionFrom;
    }

    public String getSessionTo() {
        return sessionTo;
    }

    public void setSessionTo(String sessionTo) {
        this.sessionTo = sessionTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getOnLineCount() {
        return onLineCount;
    }

    public void setOnLineCount(Integer onLineCount) {
        this.onLineCount = onLineCount;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
