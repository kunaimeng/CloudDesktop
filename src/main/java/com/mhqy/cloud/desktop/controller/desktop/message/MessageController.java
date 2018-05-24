package com.mhqy.cloud.desktop.controller.desktop.message;

import com.mhqy.cloud.desktop.common.ServerEncoder;
import com.mhqy.cloud.desktop.domin.CDSocketMessage;
import com.mhqy.cloud.desktop.service.message.CDSocketMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.controller.DesktopController.MessageController
 * @ClassName: MessageController
 * @ServerEndpoint(value = "/websocket", encoders = {ServerEncoder.class},configurator = SpringConfigurator.class)
 * @Description:消息
 * @author: peiqiankun
 * @date: 2018-03-12 11:22
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@ServerEndpoint(value = "/promptWebSocket", encoders = {ServerEncoder.class})
@Component
public class MessageController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MessageController> webSocketSet = new CopyOnWriteArraySet<MessageController>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //此处是解决无法注入的关键
    private static ApplicationContext applicationContext;

    private CDSocketMessageService cdSocketMessageService;
    public static void setApplicationContext(ApplicationContext applicationContext) {
        MessageController.applicationContext = applicationContext;
    }

    /**
     * @Description:连接建立成功调用的方法
     * @author: peiqiankun
     * @date: 2018/5/1 9:23
     * @mail: peiqiankun@jd.com
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        //加入set中
        webSocketSet.add(this);
        //在线数加1
        addOnlineCount();
        LOGGER.info("有新连接加入！当前在线人数为-->{}", getOnlineCount());
        try {
            //此处是解决无法注入的关键
            cdSocketMessageService = applicationContext.getBean(CDSocketMessageService.class);
            CDSocketMessage cdSocketMessage = cdSocketMessageService.getPrompt();
            sendMessage(cdSocketMessage);
        } catch (Exception e) {
            LOGGER.error("IO异常-->{}", e);
        }
    }

    /**
     * @Description:连接关闭调用的方法
     * @author: peiqiankun
     * @date: 2018/5/1 9:23
     * @mail: peiqiankun@jd.com
     */
    @OnClose
    public void onClose() {
        //从set中删除
        webSocketSet.remove(this);
        //在线数减1
        subOnlineCount();
        LOGGER.info("有一连接关闭！当前在线人数为-->{}", getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        LOGGER.info("来自客户端的消息-->{}", message);
        CDSocketMessage cdSocketMessage = new CDSocketMessage();
        cdSocketMessage.setMessage(message);
        //群发消息
        for (MessageController item : webSocketSet) {
            try {
                item.sendMessage(cdSocketMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Description:发生错误
     * @author: peiqiankun
     * @date: 2018/5/1 9:23
     * @mail: peiqiankun@jd.com
     */
    @OnError
    public void onError(Session session, Throwable error) {
        LOGGER.error("发生错误-->{}", error.getMessage());
    }


    public void sendMessage(CDSocketMessage message) throws IOException {
        try {
            this.session.getBasicRemote().sendObject(message);
        } catch (Exception e) {
            LOGGER.error("发送消息异常-->", e);
        }
    }

    /**
     * @Description:群发自定义消息
     * @author: peiqiankun
     * @date: 2018/5/1 9:24
     * @mail: peiqiankun@jd.com
     */
    public static void sendInfo(CDSocketMessage message) throws IOException {
        for (MessageController item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MessageController.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MessageController.onlineCount--;
    }
}
