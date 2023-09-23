package com.jmaster.notification.service;

import com.jmaster.notification.model.MessageDTO;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.springframework.kafka.annotation.KafkaHandler;
>>>>>>> 424193b6be9b87a501166d4767d39f7c686a5390
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
<<<<<<< HEAD
    @Autowired
    private EmailService emailService;

    @KafkaListener(groupId = "notificationGroup", topics = "notification")
    public void notificationService(MessageDTO messageDTO) {
        emailService.sendEmail(messageDTO);
        System.out.println("send email successfull");
    }

=======

  @KafkaListener(id = "notificationGroup", topics="notification")
  public void listen(MessageDTO messageDTO){
    System.out.println("messageDto: "+messageDTO.getContent());
  }
>>>>>>> 424193b6be9b87a501166d4767d39f7c686a5390
}
