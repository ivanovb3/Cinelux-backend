package nl.fontys.cinelux.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class MessageMapper {
    @MessageMapping("/new")
    @SendTo("/topic/edit")
    public String getSeat(String seat){
        return seat;
    }
}
