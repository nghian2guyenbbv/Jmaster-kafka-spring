package com.jmaster.accountService.controller;

import com.jmaster.accountService.model.AccountDTO;
import com.jmaster.accountService.model.MessageDTO;
import com.jmaster.accountService.model.StatictisDTO;
import com.jmaster.accountService.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    @Autowired
    private MessageRepo messageRepo;

    @PostMapping("/create")
    public AccountDTO createAcct(@RequestBody AccountDTO accountDTO) {
        StatictisDTO statictisDTO = new StatictisDTO("Account" + accountDTO.getEmail() + "was created", new Date());
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setContent("hello word");
        messageDTO.setTo("nghia");
        messageDTO.setToName("Dung");
        messageDTO.setSubject("topic sending");
        messageDTO.setStatus(false);
        messageRepo.save(messageDTO);
       /*// for(int index = 0 ; index < 100 ; index++) {
            kafkaTemplate.send("notification3", messageDTO).addCallback(new KafkaSendCallback<String, Object>() {
                @Override
                public void onSuccess(SendResult<String, Object> result) {
                    System.out.println("Sucessfully send message on partition:" + result.getProducerRecord().partition());
                }

                @Override
                public void onFailure(Throwable ex) {
                    ex.printStackTrace();
                }

                @Override
                public void onFailure(KafkaProducerException e) {
                    e.printStackTrace();
                }
            });
        //}
        //kafkaTemplate.send("statictis", messageDTO);*/
        System.out.println("sucess create acct");
        return accountDTO;
    }
}

