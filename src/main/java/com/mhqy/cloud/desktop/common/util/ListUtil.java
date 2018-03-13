package com.mhqy.cloud.desktop.common.util;

import java.util.List;

/**
 * @Description:list util
 * @author: peiqiankun
 * @date: 2018/3/10
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class ListUtil {

    /**
     * @Description:list判断非空
     * @author: peiqiankun
     * @date: 2018/3/10 20:24
     * @mail: peiqiankun@jd.com
     */
    public static boolean isNotEmpty(List list){
        if(list != null && !list.isEmpty()){
            return true;
        }
        return false;
    }
}
