package com.chatApp.ChatApp.controller;

import com.chatApp.ChatApp.model.Message;
import com.chatApp.ChatApp.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(
            @RequestParam String sender,
            @RequestParam String receiver,
            @RequestParam String content){
        Message message = messageService.sendMessage(sender, receiver, content);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Message>> getChatHistory(
            @RequestParam String user1,
            @RequestParam String user2,
            @RequestParam String content){
        List<Message> chatHistory = messageService.getChatHistory(user1, user2);
        return ResponseEntity.ok(chatHistory);
    }


}
