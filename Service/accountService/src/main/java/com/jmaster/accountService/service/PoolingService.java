package com.jmaster.accountService.service;

import com.jmaster.accountService.model.MessageDTO;
import com.jmaster.accountService.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoolingService {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Scheduled(fixedDelay = 1000)
    private void produce() {
        List<MessageDTO> falseMessages = messageRepo.findMessageDTOByStatus(false);
        for (MessageDTO messageDTO : falseMessages) {
            kafkaTemplate.send("notification3", messageDTO).addCallback(new KafkaSendCallback<String, Object>() {

                @Override
                public void onFailure(KafkaProducerException e) {
                    e.printStackTrace();
                }

                @Override
                public void onSuccess(SendResult<String, Object> result) {
                    messageDTO.setStatus(true);
                    System.out.println("Sucess send message to kafka");
                }
            });
        }
    }

}
