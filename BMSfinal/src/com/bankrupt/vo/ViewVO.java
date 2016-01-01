package com.bankrupt.vo;

public class ViewVO {
	private String AccountNumber;
	private String fdate;
	private String tdate;
	private String TransactionType;
	private int TransactionPerPage;
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	public int getTransactionPerPage() {
		return TransactionPerPage;
	}
	public void setTransactionPerPage(int transactionPerPage) {
		TransactionPerPage = transactionPerPage;
	}
	
	
	
}
