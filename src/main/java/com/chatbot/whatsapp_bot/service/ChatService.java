package com.chatbot.whatsapp_bot.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {
    public String generateReply(String message) {

        if (message == null) {
            return "Invalid message";
        }

        message = message.trim().toLowerCase();

        switch (message) {
            case "hi":
                return "Hello";
            case "bye":
                return "Goodbye";
            default:
                return "I don't understand";
        }
    }
}
