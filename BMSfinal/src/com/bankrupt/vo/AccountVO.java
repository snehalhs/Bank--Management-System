package com.bankrupt.vo;

public class AccountVO {
	private String accNumber;
	private String accName;
	private String accType;
	private int transactionID;
	private String txnDate;
	
	@Override
	public String toString() {
		return "AccountVO [accNumber=" + accNumber + ", accName=" + accName
				+ ", accType=" + accType + ", transactionID=" + transactionID
				+ ", txnDate=" + txnDate + "]";
	}
	public String getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
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
	
}
