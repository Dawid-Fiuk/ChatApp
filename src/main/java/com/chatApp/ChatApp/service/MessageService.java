package com.chatApp.ChatApp.service;

import com.chatApp.ChatApp.model.Message;
import com.chatApp.ChatApp.model.User;
import com.chatApp.ChatApp.repository.MessageRepository;
import com.chatApp.ChatApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public Message sendMessage(String senderUsername, String receiverUsername, String content) {
        boolean senderExists = userRepository.findByUsername(senderUsername).isPresent();
        boolean receiverExists = userRepository.findByUsername(receiverUsername).isPresent();

        if (!senderExists || !receiverExists) {
            throw new RuntimeException("Sender or Receiver not found");
        }

        Message message = new Message();
        message.setSenderUsername(senderUsername);
        message.setReceiverUsername(receiverUsername);
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());

        return messageRepository.save(message);
    }



    public List<Message> getChatHistory(String user1, String user2) {
        return messageRepository.findBySenderUsernameAndReceiverUsernameOrderByTimestampAsc(user1, user2);
    }



}
