package com.mhqy.cloud.desktop.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.common.util
 * @ClassName: BeanJsonUtil
 * @Description:BeanJsonUtil
 * @author: peiqiankun
 * @date: 2018-03-13 9:59
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class BeanJsonUtil {

    public BeanJsonUtil() {
    }

    public static String bean2Json(Object bean) {
        return bean2Json(bean, (SerializerFeature[]) null);
    }

    public static String bean2Json(Object bean, SerializerFeature[] features) {
        if (null == bean) {
            throw new IllegalArgumentException("target bean is null!");
        } else {
            try {
                String json = null;
                if (null == features) {
                    json = JSON.toJSONString(bean);
                } else {
                    json = JSON.toJSONString(bean, features);
                }
                return json;
            } catch (Exception var3) {
                throw new JSONException("Met error in converting bean to json!Error:" + var3.getMessage());
            }
        }
    }

    public static Object json2Object(String json, Class<?> targertClass) {
        if (null != json && json.length() != 0) {
            try {
                Object bean = JSON.parseObject(json, targertClass);
                return bean;
            } catch (Exception var3) {
                throw new JSONException("Met error in converting json string to bean!Error:" + var3.getMessage());
            }
        } else {
            throw new IllegalArgumentException("input json string is blank!");
        }
    }

    public static Object json2Object(String json, Class<?> targertClass, Feature... features) {
        if (null != json && json.length() != 0) {
            try {
                Object bean = JSON.parseObject(json, targertClass, features);
                return bean;
            } catch (Exception var4) {
                throw new JSONException("Met error in converting json string to bean!Error:" + var4.getMessage());
            }
        } else {
            throw new IllegalArgumentException("input json string is blank!");
        }
    }

    public static JSONObject toJsonObject(String json) {
        if (null != json && json.length() != 0) {
            try {
                JSONObject jsonObj = JSON.parseObject(json);
                return jsonObj;
            } catch (Exception var2) {
                throw new JSONException("Met error in converting json string to bean!Error:" + var2.getMessage());
            }
        } else {
            throw new IllegalArgumentException("input json string is blank!");
        }
    }

    public JSONArray toJsonArray(String json) {
        if (null != json && json.length() != 0) {
            try {
                JSONArray jsonArray = JSON.parseArray(json);
                return jsonArray;
            } catch (Exception var3) {
                throw new JSONException("Met error in converting json string to bean!Error:" + var3.getMessage());
            }
        } else {
            throw new IllegalArgumentException("input json string is blank!");
        }
    }
}
