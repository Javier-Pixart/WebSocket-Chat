package ar.com.pixartargentina.pixartchat.controller;

import ar.com.pixartargentina.pixartchat.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/messages")//aca solo entra lo que es enviado a "/app/messages" por que solo con el prefijo "/app" entra al controlador
    @SendTo("/topic/messages")
    public Message getMessage(Message message){
        return message;
    }

}
