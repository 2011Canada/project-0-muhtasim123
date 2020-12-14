package com.revature.models;

public class Transfers {

	private String accountFrom;
	private String accountTo;
	private double amount;
	private int transferId;
	private int transferStatus;
	private int customerId;
	
	public Transfers(String accountFrom, String accountTo, double amount) {
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
		this.amount = amount;
	}
	
	//default
	public Transfers() {
		super();
	}

	public String getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}

	public String getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(String accountTo) {
		this.accountTo = accountTo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public int getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(int transferStatus) {
		this.transferStatus = transferStatus;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
}
