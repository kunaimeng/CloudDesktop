package com.mhqy.cloud.desktop.domin;

/**
 * @Description:msg消息 sessionid 数据 user信息对应关系
 * @author: peiqiankun
 * @date: 2018/5/25
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class MsgUserSessionRelation {

    /**
     * session id
     */
    private String userId;

    /**
     * user信息
     */
    private CDUser cdUser;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CDUser getCdUser() {
        return cdUser;
    }

    public void setCdUser(CDUser cdUser) {
        this.cdUser = cdUser;
    }
}
