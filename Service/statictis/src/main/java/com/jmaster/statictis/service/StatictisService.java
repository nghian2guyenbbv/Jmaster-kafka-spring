package com.jmaster.statictis.service;

import com.jmaster.statictis.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
public class StatictisService {
    @Autowired
    private KafkaTemplate<Object, String> kafkaTemplate;

    @RetryableTopic(attempts = "3", dltTopicSuffix = "-dlt", backoff = @Backoff(delay = 1_000, multiplier = 2))
    @KafkaListener(groupId = "statictisGroup2", topics = "statictis2")
    public void receiveStaticMess(MessageDTO messageDTO) {
        System.out.println("Statictis receive message " + messageDTO.getToName());
        throw new RuntimeException();
    }

    @KafkaListener(id = "dtlGroup", topics = "statictis2-dlt")
    public void deadLetterMessage(MessageDTO messageDTO) {
        System.out.println("Receive message from dead letter message: " + messageDTO.getTo_email());

    }

}
