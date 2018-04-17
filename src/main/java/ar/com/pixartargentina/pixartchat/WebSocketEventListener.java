package ar.com.pixartargentina.pixartchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import java.text.DateFormat;
import java.util.Date;

@Component
public class WebSocketEventListener {

    @Autowired
    private SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent sessionConnectedEvent){
        System.out.println("new connection: "+sessionConnectedEvent.getMessage()+" at: "+new Date(sessionConnectedEvent.getTimestamp()));

    }
}
