package com.dvivasva.transfer.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Transfer {
    @Id
    private String id;
    private String cardNumber;
    private String idAccountOrigin;
    private String idAccountDestination;
    private double amount;
    private double commission;
    private String description;
    private Date date;

}
