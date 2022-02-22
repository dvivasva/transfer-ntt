package com.dvivasva.transfer.webclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PaymentDto {
    private String id;
    private double amount;
    private double commission;
    private String description;
    private String creditId;
    private Date date;
    private String param;
}
