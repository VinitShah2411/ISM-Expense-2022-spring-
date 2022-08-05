package com.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ExpenseBean {
	private String account_type;
	private String upi_id;
	private Integer categoryId;
	Integer userId;
	Integer expenseId;
	private Integer subcategoryId;

	public Integer getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(Integer subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	@NotBlank(message = "Please Enter Expense Name")
	String expense_name;

	@NotBlank(message = "Please Enter Expense Description")
	String expense_description;

	@NotNull(message = "Please Enter Amount")
	Integer expense_amount;

	@NotBlank(message = "Please select Date")
	String expense_date;

	@NotBlank(message = "Please Select Time")
	String expense_time;

	/* @NotBlank(message = "Please Select Payment Mode") */
	String expense_paymentmode;

	public String getAccount_type() {
		return account_type;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
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

	private Integer card_number;

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getExpense_name() {
		return expense_name;
	}

	public void setExpense_name(String expense_name) {
		this.expense_name = expense_name;
	}

	public String getExpense_description() {
		return expense_description;
	}

	public void setExpense_description(String expense_description) {
		this.expense_description = expense_description;
	}

	public Integer getExpense_amount() {
		return expense_amount;
	}

	public void setExpense_amount(Integer expense_amount) {
		this.expense_amount = expense_amount;
	}

	public String getExpense_date() {
		return expense_date;
	}

	public void setExpense_date(String expense_date) {
		this.expense_date = expense_date;
	}

	public String getExpense_time() {
		return expense_time;
	}

	public void setExpense_time(String expense_time) {
		this.expense_time = expense_time;
	}

	public String getExpense_paymentmode() {
		return expense_paymentmode;
	}

	public void setExpense_paymentmode(String expense_paymentmode) {
		this.expense_paymentmode = expense_paymentmode;
	}

}
