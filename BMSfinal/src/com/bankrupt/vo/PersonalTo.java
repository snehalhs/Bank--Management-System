package com.bankrupt.vo;

public class PersonalTo {

	private long annual_income;
	private String company_name;
	private String designation;
	private Double totalexp;
	private Double currentexp;
	private String account_number;
	private String loan_id;
	
	
	@Override
	public String toString() {
		return "PersonalTo [annual_income=" + annual_income + ", company_name="
				+ company_name + ", designation=" + designation + ", totalexp="
				+ totalexp + ", currentexp=" + currentexp + ", account_number="
				+ account_number + ", loan_id=" + loan_id + "]";
	}


	public long getAnnual_income() {
		return annual_income;
	}


	public void setAnnual_income(long annual_income) {
		this.annual_income = annual_income;
	}


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Double getTotalexp() {
		return totalexp;
	}


	public void setTotalexp(Double totalexp) {
		this.totalexp = totalexp;
	}


	public Double getCurrentexp() {
		return currentexp;
	}


	public void setCurrentexp(Double currentexp) {
		this.currentexp = currentexp;
	}


	public String getAccount_number() {
		return account_number;
	}


	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}


	public String getLoan_id() {
		return loan_id;
	}


	public void setLoan_id(String loan_id) {
		this.loan_id = loan_id;
	}
	
	
	


	
	
	
	
	
}
