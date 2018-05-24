package com.mhqy.cloud.desktop.common;

/**
 * @Description:chat类型枚举
 * @author: peiqiankun
 * @date: 2018/5/21
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public enum Constant {

    CHAT_CODE_CHAT001("CHAT001","上线通知"),
    CHAT_CODE_CHAT002("CHAT002","下线通知"),
    CHAT_CODE_CHAT003("CHAT003","普通消息");

    // 成员变量
    private String code;
    private String desc;

    // 构造方法
    private Constant(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    // 普通方法
    public static String getCode(String desc) {
        for (Constant c : Constant.values()) {
            if (c.getDesc() == desc) {
                return c.code;
            }
        }
        return null;
    }

    // 普通方法
    public static String getDesc(String code) {
        for (Constant c : Constant.values()) {
            if (c.getCode() == code) {
                return c.getDesc();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
