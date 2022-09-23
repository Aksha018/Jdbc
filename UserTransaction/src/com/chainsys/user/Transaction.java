package com.chainsys.user;

public class Transaction {
	private int transactionId;
	private int userId;
	private int receiverId;
	private double indianRupees;
	private double currency;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getIndianRupees() {
		return indianRupees;
	}
	public void setIndianRupees(double indianRupees) {
		this.indianRupees = indianRupees;
	}
	public double getCurrency() {
		return currency;
	}
	public void setCurrency(double currency) {
		this.currency = currency;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	
}