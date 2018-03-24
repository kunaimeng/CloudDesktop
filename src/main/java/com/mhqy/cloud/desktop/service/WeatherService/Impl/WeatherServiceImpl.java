package com.mhqy.cloud.desktop.service.WeatherService.Impl;

import com.mhqy.cloud.desktop.service.WeatherService.WeatherService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:天气爬取接口实现
 * @author: peiqiankun
 * @date: 2018/3/24
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Override
    public List<String> getProvinceUrl(Document document) {
        List<String> list = new ArrayList<>();
        Elements elements = document.getElementsByClass("lqcontentBoxheader");
        elements = elements.select("a");
        for (Element e : elements) {
            list.add("www.weather.com.cn" + e.attr("href"));
        }
        return list;
    }

    @Override
    public List<String> getCity(Document document) {
        return null;
    }

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
            doc = Jsoup.connect(url).userAgent("Chrome/26.0.1410.64").timeout(3000).get();
        } catch (IOException e) {
            logger.error("连接:{}出现异常,原因：{}", url, e.getMessage());
        }
        return doc;
    }
}
