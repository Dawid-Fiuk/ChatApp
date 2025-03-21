package com.chatApp.ChatApp.repository;

import com.chatApp.ChatApp.model.Message;
import com.chatApp.ChatApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long>{
    List<Message> findBySenderUsernameAndReceiverUsernameOrderByTimestampAsc(String senderUsername, String receiverUsername);
}