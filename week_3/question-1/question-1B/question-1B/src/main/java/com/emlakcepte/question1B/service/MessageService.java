package com.emlakcepte.question1B.service;

import com.emlakcepte.question1B.Repository.MessageRepository;
import com.emlakcepte.question1B.model.Message;
import com.emlakcepte.question1B.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }



    public void sendMessage(Message message) {
        messageRepository.sendMessage(message);
    }
}
