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

    public Message sendMessage(String senderUsername, String receiverUsername, String content){
        Optional<User> senderOpt = userRepository.findByUsername(senderUsername);
        Optional<User> receiverOpt = userRepository.findByUsername(receiverUsername);

        if (senderOpt.isEmpty() || receiverOpt.isEmpty()){
            throw new IllegalArgumentException("Sender or receiver not found");
        }

        Message message = Message.builder()
                .sender(senderOpt.get())
                .receiver(receiverOpt.get())
                .content(content)
                .timestamp(LocalDateTime.now())
                .build();

        return messageRepository.save(message);
    }

    public List<Message> getChatHistory(String user1, String user2){
        Optional<User> user1Opt = userRepository.findByUsername(user1);
        Optional<User> user2Opt = userRepository.findByUsername(user2);

        if(user1Opt.isEmpty() || user2Opt.isEmpty()){
            throw new IllegalArgumentException("one or both users not found");
        }

        return messageRepository.findBySenderAndReceiverOrderByTimestampAsc(user1Opt.get(), user2Opt.get());
    }


}
