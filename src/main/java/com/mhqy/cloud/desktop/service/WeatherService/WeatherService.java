package com.mhqy.cloud.desktop.service.WeatherService;

import com.mhqy.cloud.desktop.domin.WeatherDomin.CDWeather;
import org.jsoup.nodes.Document;

import java.util.List;

/**
 * @Description:天气爬取接口
 * @author: peiqiankun
 * @date: 2018/3/24
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface WeatherService {

    /**
     * @Description:获取所有省市列表
     * @author: peiqiankun
     * @date: 2018/3/24 22:53
     * @mail: peiqiankun@jd.com
     */
    List<String> getProvinceUrl(Document document);

    /**
     * @Description:根据省URL获取市相关列表
     * @author: peiqiankun
     * @date: 2018/3/24 22:54
     * @mail: peiqiankun@jd.com
     */
    List<String> getCity(Document document);

    /**
     * @Description:获取网页信息
     * @author: peiqiankun
     * @date: 2018/3/24 23:05
     * @mail: peiqiankun@jd.com
     */
    Document getDocByUrl(String url);

    /**
     * @Description:查询天气
     * @author: peiqiankun
     * @date: 2018/3/25 13:38
     * @mail: peiqiankun@jd.com
     */
    CDWeather getWeather(Document document);
}
