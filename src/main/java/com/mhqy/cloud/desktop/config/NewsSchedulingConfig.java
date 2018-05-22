package com.mhqy.cloud.desktop.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.domin.CDNews;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @Description:新闻定时任务
 * @author: peiqiankun
 * @date: 2018/5/22
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class NewsSchedulingConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(NewsSchedulingConfig.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void getHotNews(){
        try{
            LOGGER.info("新闻定时任务开始执行");
            String path = "http://v.juhe.cn/toutiao/index?type=top&key=270bcc91e2a8ef430f74e8319e6af774";
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.flush();
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();
            JsonParser parse = new JsonParser();
            JsonObject jsonObject =  (JsonObject)parse.parse(bos.toString("utf-8"));
            JsonObject result= (JsonObject)jsonObject.get("result");
            List<CDNews> cdNews = (List) BeanJsonUtil.json2Object(result.get("data").toString(),List.class);
            LOGGER.info("新闻存入redis信息：key:{},value:{}","news",cdNews);
            redisTemplate.opsForValue().set("news", BeanJsonUtil.bean2Json(cdNews));
        }catch(Exception e){
            LOGGER.error("新闻定时任务执行出现异常：{}",e);
        }
    }
}
