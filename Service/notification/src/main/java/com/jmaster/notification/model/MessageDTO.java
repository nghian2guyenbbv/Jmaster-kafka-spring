package com.jmaster.notification.model;

import lombok.Data;

@Data
public class MessageDTO {
    private String to;
    private String toName;
    private String content;
    private String subject;

}
