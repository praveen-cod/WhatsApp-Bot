package com.chatbot.whatsapp_bot.controller;

import com.chatbot.whatsapp_bot.models.MessageRequest;
import com.chatbot.whatsapp_bot.models.MessageResponse;
import com.chatbot.whatsapp_bot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @CrossOrigin(origins = "*") // IMPORTANT for frontend
    public class ChatController {

        @Autowired
        private ChatService chatService;

        @PostMapping("/webhook")
        public MessageResponse receiveMessage(@RequestBody MessageRequest request) {

            // Logging incoming message
            System.out.println("Received message: " + request.getMessage());

            String reply = chatService.generateReply(request.getMessage());

            return new MessageResponse(reply);
        }
}
