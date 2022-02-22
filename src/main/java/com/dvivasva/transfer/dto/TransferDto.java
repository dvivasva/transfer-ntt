package com.dvivasva.transfer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class TransferDto {
    private String id;
    private String cardNumber;
    private String idAccountOrigin;
    private String idAccountDestination;
    private double amount;
    private double commission;
    private String description;
    private Date date;
}
