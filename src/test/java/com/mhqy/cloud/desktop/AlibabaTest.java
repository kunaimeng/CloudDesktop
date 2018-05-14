package com.mhqy.cloud.desktop;

import java.util.*;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/5/5
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class AlibabaTest {
    public static void main(String[] args){
//        List<String> list = new ArrayList<String>(2);
//        list.add("guan");
//        list.add("bao");
//        String[] array = new String[3];
//        System.out.println(array);
//        array = list.toArray(array);
//        System.out.println(array);
//        System.out.println(array[1]);
//        boolean b = Objects.equals(1, 1);

        /*
        *
        *
        *
        *
        * */
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

    }
}
