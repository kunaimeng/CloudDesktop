package com.mhqy.cloud.desktop.common;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/5/21
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public enum Constant {
    FILE_UPLOAD_TMP_PATH("D:\\upload", "1");
    // 成员变量
    private String key;
    private String value;

    // 构造方法
    private Constant(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // 普通方法
    public static String getName(String value) {
        for (Constant c : Constant.values()) {
            if (c.getValue() == value) {
                return c.key;
            }
        }
        return null;
    }
    // get set 方法

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
