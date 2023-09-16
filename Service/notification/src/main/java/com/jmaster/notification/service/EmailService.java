package com.jmaster.notification.service;

import com.jmaster.notification.model.MessageDTO;
import org.springframework.stereotype.Service;

public interface EmailService {
    void sendEmail(MessageDTO messageDTO);
}
