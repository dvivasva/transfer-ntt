package com.dvivasva.transfer.webclient.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;


@Getter
@Setter
public class AccountDto {

	private String id;
	private String type;
	private String number;
	private double availableBalance;
	private Date dateCreation;
	private String status;
	private String customerId;

}
