package com.jmaster.accountService.service;

import com.jmaster.accountService.model.MessageDTO;
import com.jmaster.accountService.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteTrueBatch {

    @Autowired
    private MessageRepo messageRepo;

    @Scheduled(fixedDelay = 60000)
    public void deleteSucessMessage() {
        List<MessageDTO> trueMessage = messageRepo.findMessageDTOByStatus(true);
        messageRepo.deleteAllInBatch(trueMessage);
    }
}
