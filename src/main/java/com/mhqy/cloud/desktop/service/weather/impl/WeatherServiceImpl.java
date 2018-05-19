package com.mhqy.cloud.desktop.service.weather.impl;

import com.mhqy.cloud.desktop.domin.WeatherDomin.CDWeather;
import com.mhqy.cloud.desktop.domin.WeatherDomin.Weather;
import com.mhqy.cloud.desktop.service.weather.WeatherService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            list.add("http://www.weather.com.cn" + e.attr("href"));
        }
        return list;
    }

    @Override
    public List<String> getCity(Document document) {
        List<String> list = new ArrayList<>();
        Elements elements = document.getElementsByClass("conMidtab");
        elements = elements.first().getElementsByClass("conMidtab3");
        for (Element element : elements) {
            list.add(element.getElementsByClass("last").select("a").attr("href"));
        }
        return list;
    }



    @Override
    public CDWeather getWeather(Document document) {
        String str;
        List<Weather> list = new ArrayList<>();
        CDWeather cdWeather = new CDWeather();
        cdWeather.setAddressId(document.location().substring(document.location().lastIndexOf("/") + 1, document.location().lastIndexOf(".")));
        cdWeather.setProvince(document.getElementsByClass("ctop").first().select("a").text());
        cdWeather.setCity(document.getElementsByClass("ctop").first().select("span").last().text());
        cdWeather.setUpdateTime(new SimpleDateFormat("dd号 HH:mm:ss").format(new Date()));
        cdWeather.setFrom("中央气象台");
        Elements elements = document.getElementById("7d").getElementsByClass("t").first().getElementsByClass("sky");
        for (Element element : elements) {
            Weather weather = new Weather();
            str = element.select("h1").text();
            weather.setDate(str.substring(0,str.indexOf("（")));
            weather.setWeek(str.substring(str.indexOf("（")+1,str.indexOf("）")));
            weather.setWeatherDesc(element.select(".wea").text());
            weather.setMaxTemp(element.select(".tem").select("span").text());
            weather.setMinTemp(element.select(".tem").select("i").text());
            weather.setWindFrom(element.select(".win").select("em").select("span").attr("title"));
            weather.setWinTo(element.select(".win").select("em").select("span").attr("title"));
            weather.setWindSpeed(element.select(".win").select("i").text());
            list.add(weather);
        }
        cdWeather.setWeathers(list);
        return cdWeather;
    }
}
