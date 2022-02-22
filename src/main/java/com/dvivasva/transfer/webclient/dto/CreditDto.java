package com.dvivasva.transfer.webclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreditDto {
    private String id;
    private String customerId;
    private String nameProduct;
    private double creditLine;
    private double availableBalance;
    private double spending;
    private double payments;
    private Date dateStart;
    private Date dateLimit;
    private int numberDueTotal;
    private int numberDuePending;
}
