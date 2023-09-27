package com.jmaster.accountService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MessageDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="to_email")
    private String to;
    private String toName;
    private String subject;
    private String content;
    private boolean status;

}
