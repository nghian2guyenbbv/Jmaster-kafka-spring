package com.jmaster.accountService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class StatictisDTO {
    private String message;
    private Date createdDate;
}
