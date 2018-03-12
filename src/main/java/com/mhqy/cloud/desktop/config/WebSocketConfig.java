package com.mhqy.cloud.desktop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.config
 * @ClassName: WebSocketConfig
 * @Description:websocket配置
 * @author: peiqiankun
 * @date: 2018-03-12 9:38
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
