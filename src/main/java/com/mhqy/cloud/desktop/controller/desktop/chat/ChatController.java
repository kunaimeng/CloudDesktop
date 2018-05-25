package com.mhqy.cloud.desktop.controller.desktop.chat;

import com.mhqy.cloud.desktop.common.Constant;
import com.mhqy.cloud.desktop.common.ServerEncoder;
import com.mhqy.cloud.desktop.common.util.BeanJsonUtil;
import com.mhqy.cloud.desktop.config.GetHttpSessionConfig;
import com.mhqy.cloud.desktop.domin.CDSocketMessage;
import com.mhqy.cloud.desktop.domin.CDUser;
import com.mhqy.cloud.desktop.service.user.CDUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
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
@ServerEndpoint(value = "/chatSocket/{userId}", encoders = {ServerEncoder.class},configurator = GetHttpSessionConfig.class)
@Component
public class ChatController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ChatController.class);

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<ChatController> webSocketSet = new CopyOnWriteArraySet<ChatController>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //此处是解决无法注入的关键
    private static ApplicationContext applicationContext;

    private HttpSession httpSession;
    private CDUserService cdUserService;

    public ChatController() {
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ChatController.applicationContext = applicationContext;
    }

    /**
     * @Description:连接建立成功调用的方法
     * @author: peiqiankun
     * @date: 2018/5/1 9:23
     * @mail: peiqiankun@jd.com
     */
    @OnOpen
    public void onOpen(@PathParam(value="userId") String userId, Session session, EndpointConfig config) {
        this.session = session;
        //加入set中
        webSocketSet.add(this);
        //在线数加1
        addOnlineCount();
        LOGGER.info("[聊天]有新连接加入！当前在线人数为-->{}", getOnlineCount());
        try {
            openAndClose(Constant.CHAT_CODE_CHAT001.getCode(),config,userId);
        } catch (Exception e) {
            LOGGER.error("[聊天]上线异常-->{}", e);
        }
    }

    /**
     * @Description:连接关闭调用的方法
     * @author: peiqiankun
     * @date: 2018/5/1 9:23
     * @mail: peiqiankun@jd.com
     */
    @OnClose
    public void onClose(@PathParam(value="userId") String userId) {
        try{
            openAndClose(Constant.CHAT_CODE_CHAT002.getCode(),null,userId);
        }catch (Exception e){
            LOGGER.error("[聊天]下线异常-->{}", e);
        }
        //从set中删除
        webSocketSet.remove(this);
        //在线数减1
        subOnlineCount();
        LOGGER.info("[聊天]有一连接关闭！当前在线人数为-->{}", getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(@PathParam(value="userId") String userId,String message, Session session) {
        LOGGER.info("[聊天]来自客户端的消息-->{}", message);
        cdUserService = applicationContext.getBean(CDUserService.class);
        CDSocketMessage cdSocketMessage = new CDSocketMessage();
        cdSocketMessage.setFrom(cdUserService.selectByPrimaryKey(Long.parseLong(userId)));
        //session
        cdSocketMessage.setSessionFrom(session.getId());
        //信息 类型 code
        cdSocketMessage.setCode(Constant.CHAT_CODE_CHAT003.getCode());
        cdSocketMessage.setTitle(Constant.getDesc(Constant.CHAT_CODE_CHAT003.getCode()));
        cdSocketMessage.setMessage(Constant.getDesc(Constant.CHAT_CODE_CHAT003.getCode()));
        //当前在线
        cdSocketMessage.setData(this.webSocketSet);
        //当前在线人数
        cdSocketMessage.setOnLineCount(getOnlineCount());
        cdSocketMessage.setMessage(message);
        //群发消息
        for (ChatController item : webSocketSet) {
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
        LOGGER.error("[聊天]发生错误-->{}", error.getMessage());
    }


    public void sendMessage(CDSocketMessage message) throws IOException {
        try {
            this.session.getBasicRemote().sendObject(message);
        } catch (Exception e) {
            LOGGER.error("[聊天]发送消息异常-->", e);
        }
    }

    /**
     * @Description:群发自定义消息
     * @author: peiqiankun
     * @date: 2018/5/1 9:24
     * @mail: peiqiankun@jd.com
     */
    public static void sendInfo(CDSocketMessage message) throws IOException {
        for (ChatController item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    /**
     * @Description:连接与关闭发送通知
     * @author: peiqiankun
     * @date: 2018/5/24 18:12
     * @mail: peiqiankun@jd.com
     */
    private void openAndClose(String chatCode,EndpointConfig config,String userId) throws Exception{
        CDUser cdUser = null;
        //查询用户信息
        cdUserService = applicationContext.getBean(CDUserService.class);
        //如果是上线的话
        if(StringUtils.equals(chatCode,Constant.CHAT_CODE_CHAT001.getCode())){
             httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
             cdUser = cdUserService.selectByPrimaryKey(Long.parseLong(httpSession.getAttribute("sessionUserId").toString()));
        }else{
            //如果是下线
            cdUser = cdUserService.selectByPrimaryKey(Long.parseLong(userId));
        }
        CDSocketMessage cdSocketMessage = new CDSocketMessage();
        //from userid
        cdSocketMessage.setFrom(cdUser);
        //session
        cdSocketMessage.setSessionFrom(session.getId());
        //信息 类型 code
        cdSocketMessage.setCode(chatCode);
        cdSocketMessage.setTitle(cdUser.getUserName()+"-"+Constant.getDesc(chatCode));
        cdSocketMessage.setMessage(cdUser.getUserName()+"-"+Constant.getDesc(chatCode));
        //当前在线
        cdSocketMessage.setData(this.webSocketSet);
        //当前在线人数
        cdSocketMessage.setOnLineCount(getOnlineCount());
        LOGGER.info("聊天上线信息：{}", BeanJsonUtil.bean2Json(cdSocketMessage));
        sendInfo(cdSocketMessage);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        ChatController.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        ChatController.onlineCount--;
    }
}
