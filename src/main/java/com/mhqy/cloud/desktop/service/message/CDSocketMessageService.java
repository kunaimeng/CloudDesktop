package com.mhqy.cloud.desktop.service.message;

import com.mhqy.cloud.desktop.domin.CDSocketMessage;

/**
 * @Description:
 * @author: peiqiankun
 * @date: 2018/5/23
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public interface CDSocketMessageService {

    /**
     * @Description:获取用户登录第一次提示语
     * @author: peiqiankun
     * @date: 2018/5/23 15:57
     * @mail: peiqiankun@jd.com
     */
    CDSocketMessage getPrompt();

}
