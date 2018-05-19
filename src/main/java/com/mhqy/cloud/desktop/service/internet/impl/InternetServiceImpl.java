package com.mhqy.cloud.desktop.service.internet.impl;

import com.mhqy.cloud.desktop.service.internet.InternetService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/5/19
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service
public class InternetServiceImpl implements InternetService{

    private final static Logger logger = LoggerFactory.getLogger(InternetServiceImpl.class);

    /**
     * @Description:获取网页信息
     * @author: peiqiankun
     * @date: 2018/3/24 23:04
     * @mail: peiqiankun@jd.com
     */
    @Override
    public Document getDocByUrl(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent("Chrome/26.0.1410.64").timeout(30000).get();
        } catch (IOException e) {
            logger.error("连接:{}出现异常,原因：{}", url, e.getMessage());
        }
        return doc;
    }
}
