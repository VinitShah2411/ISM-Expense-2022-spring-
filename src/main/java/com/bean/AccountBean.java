package com.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;



public class AccountBean {

	Integer userId;
	Integer account_id;
	
	private String account_type;
	
	@NotNull(message = "Please Enter Amount")
	private Integer account_balance;

	@NotBlank(message = "Please Enter UPI")
	private String upi_id;
	
	@NotNull(message = "Please Enter Card Number")
	@Range(min=1000, max = 9999 ,message = "Please Enter last 4 digit Card ") 
//	@Max(value = 1000,message = "Please Enter last 4 digit Card")
	private Integer card_number;
	
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	public Integer getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(Integer account_balance) {
		this.account_balance = account_balance;
	}
	public String getUpi_id() {
		return upi_id;
	}
	public void setUpi_id(String upi_id) {
		this.upi_id = upi_id;
	}
	public Integer getCard_number() {
		return card_number;
	}
	public void setCard_number(Integer card_number) {
		this.card_number = card_number;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
