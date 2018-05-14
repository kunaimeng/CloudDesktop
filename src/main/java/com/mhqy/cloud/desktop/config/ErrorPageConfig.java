package com.mhqy.cloud.desktop.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @Description:错误跳转页面配置
 * @author: peiqiankun
 * @date: 2018/3/4
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Configuration
public class ErrorPageConfig {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/ErrorPage/400");
                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/ErrorPage/401");
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/ErrorPage/404");
                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/ErrorPage/500");
                container.addErrorPages(error400Page, error401Page, error404Page, error500Page);
            }
        };
    }
}
