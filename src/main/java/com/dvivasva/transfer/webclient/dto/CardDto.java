package com.dvivasva.transfer.webclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CardDto {

    private String id;
    private String type; // debt or credit
    private String number;
    private Date dueDate;
    private String cardVerificationValue;
    private String keyATM;
    private String keyInternet;
    private List<String> connectTo; // account or credit "connectTo" : [ "ACC-001", "ACC-004", "ACC-001" ]
}
