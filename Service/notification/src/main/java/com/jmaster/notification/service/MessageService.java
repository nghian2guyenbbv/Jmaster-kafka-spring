package com.jmaster.notification.service;

import com.jmaster.notification.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private EmailService emailService;

    @KafkaListener(groupId = "notificationGroup2", topics = "notification3")
    public void notificationService(MessageDTO messageDTO) {
        emailService.sendEmail(messageDTO);
        System.out.println("messageDto: "+messageDTO.getContent());
        System.out.println("send email successfull");
        //throw new RuntimeException();
    }

    @KafkaListener(groupId = "dltGroup", topics = "notification3.DLT")
    public void dltListener(MessageDTO messageDTO){
        System.out.println("Received notification dead letter from: "+messageDTO.getTo_email());

    }

}
