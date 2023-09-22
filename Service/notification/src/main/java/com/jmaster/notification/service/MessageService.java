package com.jmaster.notification.service;

import com.jmaster.notification.model.MessageDTO;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  @KafkaListener(id = "notificationGroup", topics="notification")
  public void listen(MessageDTO messageDTO){
    System.out.println("messageDto: "+messageDTO.getContent());
  }
}
