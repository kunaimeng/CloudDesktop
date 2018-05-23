package com.mhqy.cloud.desktop.service.message.impl;

import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.domin.CDSocketMessage;
import com.mhqy.cloud.desktop.service.message.CDSocketMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/5/23
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@Service("cDSocketMessageService")
public class CDSocketMessageServiceImpl implements CDSocketMessageService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @Description:获取用户登录第一次提示语
     * @author: peiqiankun
     * @date: 2018/5/23 15:57
     * @mail: peiqiankun@jd.com
     */
    @Override
    public CDSocketMessage getPrompt() {
        CDSocketMessage cdSocketMessage = new CDSocketMessage();
        if (!redisTemplate.hasKey("prompt")) {
            cdSocketMessage.setTitle("小主");
            cdSocketMessage.setMessage("小主，欢迎你再次使用云桌面");
        } else {
            cdSocketMessage = (CDSocketMessage) BeanJsonUtil.json2Object(redisTemplate.opsForValue().get("prompt").toString(), CDSocketMessage.class);
        }
        return cdSocketMessage;
    }
}