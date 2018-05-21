package com.mhqy.cloud.desktop.common;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/5/21
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public enum Constant {
    FILE_UPLOAD_TMP_PATH("D:\\upload",1);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private Constant(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (Constant c : Constant.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
