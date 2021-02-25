package work.zhili.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2021/2/24 18:16
 */
@Component
@ServerEndpoint("/api/v1/im/{id}")
public class InstantMessagingController {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private static final ConcurrentHashMap<String, Set<Session>> WEB_SOCKET_MAP = new ConcurrentHashMap<>(32);

    @OnOpen
    public void onOpen(Session session, @PathParam("id") String id) {
        if (WEB_SOCKET_MAP.containsKey(id)) {
            WEB_SOCKET_MAP.get(id).add(session);
        } else {
            Set<Session> sessions = Collections.synchronizedSet(new HashSet<>(16));
            sessions.add(session);
            WEB_SOCKET_MAP.put(id, sessions);
        }
        log.info("[{}] log in", id);
    }

    @OnClose
    public void onClose(Session session, @PathParam("id") String id) {
        if (WEB_SOCKET_MAP.containsKey(id)) {
            WEB_SOCKET_MAP.get(id).remove(session);
        }
        log.info("[{}] log out", id);
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("id") String id) {
        log.info("receive message: id [{}], message [{}]", id, message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("error !!! session: [{}]", session, error);
    }

    public void sendMessage(String id, String message) {
        try {
            for (Session session : WEB_SOCKET_MAP.get(id)) {
                session.getBasicRemote().sendText(message);
                log.info("send message: id [{}], message [{}]", id, message);
            }
        } catch (IOException e) {
            log.error("error", e);
        }
    }

}
