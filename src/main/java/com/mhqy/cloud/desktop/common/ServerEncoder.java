package com.mhqy.cloud.desktop.common;

import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.domin.CDSocketMessage;


import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.common
 * @ClassName: ServerEncoder
 * @Description:definition for our encoder
 * @author: peiqiankun
 * @date: 2018-03-12 12:00
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class ServerEncoder implements Encoder.Text<CDSocketMessage> {
    @Override
    public String encode(CDSocketMessage messagepojo) throws EncodeException {
        return BeanJsonUtil.bean2Json(messagepojo);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
