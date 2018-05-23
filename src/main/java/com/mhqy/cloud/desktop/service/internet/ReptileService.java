package com.mhqy.cloud.desktop.service.internet;

/**
 * @Description:爬虫service
 * @author: peiqiankun
 * @date: 2018/5/23
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface ReptileService {

    /**
     * @Description:获取热点新闻
     * @author: peiqiankun
     * @date: 2018/5/23 10:09
     * @mail: peiqiankun@jd.com
     */
    void getHotNews() throws Exception;

    /**
     * @Description:获取热点新闻
     * @author: peiqiankun
     * @date: 2018/5/23 10:09
     * @mail: peiqiankun@jd.com
     */
    void getWallpaper() throws Exception;

    /**
     * @Description:获取热点新闻
     * @author: peiqiankun
     * @date: 2018/5/23 10:09
     * @mail: peiqiankun@jd.com
     */
    void getWeather() throws Exception;

}
