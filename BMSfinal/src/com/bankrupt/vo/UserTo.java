package com.bankrupt.vo;

public class UserTo {
	private String loan_type;
	private int loan_amount;
	private String loan_apply_date;
	private String loan_issue_date;
	private Double rate_of_interest;
	private int duration_of_loan;
	private String loan_id;
	private Double EMI;
	private String account_number;
	
	
	
	@Override
	public String toString() {
		return "UserTo [loan_type=" + loan_type + ", loan_amount="
				+ loan_amount + ", loan_apply_date=" + loan_apply_date
				+ ", loan_issue_date=" + loan_issue_date
				+ ", rate_of_interest=" + rate_of_interest
				+ ", duration_of_loan=" + duration_of_loan + ", loan_id="
				+ loan_id + ", EMI=" + EMI + ", account_number="
				+ account_number + "]";
	}



	public String getLoan_type() {
		return loan_type;
	}



	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}



	public int getLoan_amount() {
		return loan_amount;
	}



	public void setLoan_amount(int loan_amount) {
		this.loan_amount = loan_amount;
	}



	public String getLoan_apply_date() {
		return loan_apply_date;
	}



	public void setLoan_apply_date(String loan_apply_date) {
		this.loan_apply_date = loan_apply_date;
	}



	public String getLoan_issue_date() {
		return loan_issue_date;
	}



	public void setLoan_issue_date(String loan_issue_date) {
		this.loan_issue_date = loan_issue_date;
	}



	public Double getRate_of_interest() {
		return rate_of_interest;
	}



	public void setRate_of_interest(Double rate_of_interest) {
		this.rate_of_interest = rate_of_interest;
	}



	public int getDuration_of_loan() {
		return duration_of_loan;
	}



	public void setDuration_of_loan(int duration_of_loan) {
		this.duration_of_loan = duration_of_loan;
	}



	public String getLoan_id() {
		return loan_id;
	}



	public void setLoan_id(String loan_id) {
		this.loan_id = loan_id;
	}



	public Double getEMI() {
		return EMI;
	}



	public void setEMI(Double eMI) {
		EMI = eMI;
	}



	public String getAccount_number() {
		return account_number;
	}



	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
