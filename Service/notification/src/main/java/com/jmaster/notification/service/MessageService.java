package com.jmaster.notification.service;

import com.jmaster.notification.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private EmailService emailService;

    @KafkaListener(groupId = "notificationGroup", topics = "notification")
    public void notificationService(MessageDTO messageDTO) {
        emailService.sendEmail(messageDTO);
        System.out.println("send email successfull");
    }

}
