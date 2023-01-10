package com.emlakcepte.question1B.controller;

import com.emlakcepte.question1B.model.Message;
import com.emlakcepte.question1B.model.User;
import com.emlakcepte.question1B.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    @Autowired
    public MessageService messageService;

    @GetMapping
    public List<Message> getAllUsers(){

        return messageService.getAll();
    }
    @PostMapping
    public void sendMessage(@RequestBody Message message){
        messageService.sendMessage(message);
    }


}
