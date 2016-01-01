package com.bankrupt.vo;

import java.util.Date;

public class TransactionVO {
	private String accNumber;
	private String accName;
	private String accType;
	private int transactionID;
	private String transactionType;
	private Date transactionDate;
	private double amount;
	private double balance;
	private String txnDate;
	
		
	@Override
	public String toString() {
		return "TransactionVO [accNumber=" + accNumber + ", accName=" + accName
				+ ", accType=" + accType + ", transactionID=" + transactionID
				+ ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", amount=" + amount + ", balance="
				+ balance + ", txnDate=" + txnDate + "]";
	}
	public String getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
