package com.mhqy.cloud.desktop.schedul;

import com.mhqy.cloud.desktop.service.internet.ReptileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * @Description:新闻定时任务
 * @author: peiqiankun
 * @date: 2018/5/22
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class NewsScheduling {

    private final static Logger LOGGER = LoggerFactory.getLogger(NewsScheduling.class);

    @Autowired
    private ReptileService reptileService;

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void getHotNews(){
        LOGGER.info("[定时任务]获取新闻");
        try{
            reptileService.getHotNews();
        }catch(Exception e){
            LOGGER.error("新闻定时任务执行出现异常：{}",e);
        }
    }
}
