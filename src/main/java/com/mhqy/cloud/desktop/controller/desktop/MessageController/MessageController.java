package com.mhqy.cloud.desktop.controller.desktop.MessageController;

import com.mhqy.cloud.desktop.common.ServerEncoder;
import com.mhqy.cloud.desktop.domin.CDSocketMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.controller.DesktopController.MessageController
 * @ClassName: MessageController
 * @Description:消息
 * @author: peiqiankun
 * @date: 2018-03-12 11:22
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
@ServerEndpoint(value = "/websocket", encoders = {ServerEncoder.class})
@Component
public class MessageController {

    private final static Logger logger = LoggerFactory.getLogger(MessageController.class);

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MessageController> webSocketSet = new CopyOnWriteArraySet<MessageController>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * @Description:连接建立成功调用的方法
     * @author: peiqiankun
     * @date: 2018/5/1 9:23
     * @mail: peiqiankun@jd.com
     */
    @OnOpen
    public void onOpen(Session sessions) {
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        logger.info("有新连接加入！当前在线人数为-->{}", getOnlineCount());
        CDSocketMessage cdSocketMessage = new CDSocketMessage();
        try {
            for (int i = 0; i < 10; i++) {
                cdSocketMessage.setTitle("消息" + i);
                cdSocketMessage.setMessage("新消息来了" + i);
                Thread.sleep(1000);
                sendMessage(cdSocketMessage);
            }
        } catch (Exception e) {
            logger.error("IO异常-->{}", e);
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
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();               //在线数减1
        logger.info("有一连接关闭！当前在线人数为-->{}", getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("来自客户端的消息-->{}", message);
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
        logger.error("发生错误-->{}", error.getMessage());
    }


    public void sendMessage(CDSocketMessage message) throws IOException {
        try {
            this.session.getBasicRemote().sendObject(message);
        } catch (Exception e) {
            logger.error("发送消息异常-->", e);
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
