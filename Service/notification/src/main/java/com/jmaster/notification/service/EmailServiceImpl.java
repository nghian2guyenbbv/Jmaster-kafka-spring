package com.jmaster.notification.service;

import com.jmaster.notification.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("$(spring.mail.username)")
    private String from;
    @Override
    @Async
    public void sendEmail(MessageDTO messageDTO) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
        try {
            helper.setTo("nghia.nvt96@gmail.com");
            helper.setText("message was sent from: "+messageDTO.getTo(), false);
            helper.setSubject("this is subject");
            helper.setFrom(from);
            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("fail to send email");
        }
    }
}
