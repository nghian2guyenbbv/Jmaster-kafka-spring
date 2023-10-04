package com.jmaster.statictis.dto;

import lombok.Data;

@Data
public class MessageDTO {
    private int id;
    private String to_email;
    private String toName;
    private String subject;
    private String content;
    private boolean status;
}
