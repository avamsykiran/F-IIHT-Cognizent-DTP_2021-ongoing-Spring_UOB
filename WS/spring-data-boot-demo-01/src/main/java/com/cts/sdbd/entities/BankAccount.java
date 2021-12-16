package com.cts.sdbd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class BankAccount {

	@Id
	@Column(name = "acc_num")
	private String accNumber;
	@Column(name = "ifsc", nullable = false)
	private String ifscCode;
	@Column(name = "bank_title", nullable = false)
	private String bankTitle;

	@OneToOne
	@JoinColumn
	private Employee holder;

	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankAccount(String accNumber, String ifscCode, String bankTitle, Employee holder) {
		super();
		this.accNumber = accNumber;
		this.ifscCode = ifscCode;
		this.bankTitle = bankTitle;
		this.holder = holder;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankTitle() {
		return bankTitle;
	}

	public void setBankTitle(String bankTitle) {
		this.bankTitle = bankTitle;
	}

	public Employee getHolder() {
		return holder;
	}

	public void setHolder(Employee holder) {
		this.holder = holder;
	}

	@Override
	public String toString() {
		return "BankAccount [accNumber=" + accNumber + ", ifscCode=" + ifscCode + ", bankTitle=" + bankTitle + "]";
	}

	
}
