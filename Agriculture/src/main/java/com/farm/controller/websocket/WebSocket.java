package com.farm.controller.websocket;
import com.farm.service.PacketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/11/6 9:13
 */
@Component
@ServerEndpoint("/pull")
public class WebSocket {
    public static PacketService packetService;
    private Logger logger  = LoggerFactory.getLogger(WebSocket.class);
    private Session session;
    //储存所有WebSocket连接
    private static CopyOnWriteArraySet<WebSocket> clients = new CopyOnWriteArraySet<>();
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        Map<String, Object> map = new HashMap<>();
        map.put("pack", packetService.getInitPackets());
        ObjectMapper mapper = new ObjectMapper();
        try {
            String msg = mapper.writeValueAsString(map);
            session.getBasicRemote().sendText(msg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clients.add(this);
        logger.info("新连接");
    }
    @OnClose
    public void onClose() {
        clients.remove(this);
        logger.info("连接断开！");
    }
    @OnError
    public void onError(Session session, Throwable error) {
        logger.info("有异常啦");
        //error.printStackTrace();
    }
    /**
     * 推送消息给所有WebSocket客户端
     * @param msg
     */
    public void sendMsg(String msg) {
        for (WebSocket webSocket : clients) {
            try {
                webSocket.session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void pushPacketsToUsers(Map<String,Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String msg = mapper.writeValueAsString(map);
            this.sendMsg(msg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
