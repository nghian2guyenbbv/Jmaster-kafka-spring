package com.jmaster.accountService.controller;

import com.jmaster.accountService.model.AccountDTO;
import com.jmaster.accountService.model.MessageDTO;
import com.jmaster.accountService.model.StatictisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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
    @PostMapping("/create")
    public AccountDTO createAcct(@RequestBody AccountDTO accountDTO){
        StatictisDTO statictisDTO = new StatictisDTO("Account"+accountDTO.getEmail()+"was created", new Date());
        MessageDTO messageDTO  = new MessageDTO();
        messageDTO.setContent("hello word");
        messageDTO.setTo("nghia");
        messageDTO.setToName("Hau");
        messageDTO.setSubject("topic sending");
        kafkaTemplate.send("notification", messageDTO);
        kafkaTemplate.send("statictis", statictisDTO);
        return accountDTO;
    }
}

