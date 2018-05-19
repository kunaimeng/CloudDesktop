package com.mhqy.cloud.desktop.service.internet;

import org.jsoup.nodes.Document;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/5/18
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface InternetService {
    /**
     * @Description:获取网页信息
     * @author: peiqiankun
     * @date: 2018/3/24 23:05
     * @mail: peiqiankun@jd.com
     */
    Document getDocByUrl(String url);
}
