package com.emlakcepte.question1B.Repository;

import com.emlakcepte.question1B.model.Message;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MessageRepository {
    private static List<Message> messageList=new ArrayList<>();
    public void sendMessage(Message message) {

        messageList.add(message);
    }
    public List<Message> getAll(){
        return messageList;
    }
}
