package com.bankrupt.vo;

public class EducationalTo {
	private Long course_fee;
	private String course;
	private String father_name;
	private String father_occupation;
	private Double father_totalexp;
	private Double father_currentexp;
	private Long rationcard_number;
	private Long annual_income;
	private String account_number;
	private String laon_id;
	
	
	@Override
	public String toString() {
		return "EducationalTo [course_fee=" + course_fee + ", course=" + course
				+ ", father_name=" + father_name + ", father_occupation="
				+ father_occupation + ", father_totalexp=" + father_totalexp
				+ ", father_currentexp=" + father_currentexp
				+ ", rationcard_number=" + rationcard_number
				+ ", annual_income=" + annual_income + ", account_number="
				+ account_number + ", laon_id=" + laon_id + "]";
	}


	public Long getCourse_fee() {
		return course_fee;
	}


	public void setCourse_fee(Long course_fee) {
		this.course_fee = course_fee;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getFather_name() {
		return father_name;
	}


	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}


	public String getFather_occupation() {
		return father_occupation;
	}


	public void setFather_occupation(String father_occupation) {
		this.father_occupation = father_occupation;
	}


	public Double getFather_totalexp() {
		return father_totalexp;
	}


	public void setFather_totalexp(Double father_totalexp) {
		this.father_totalexp = father_totalexp;
	}


	public Double getFather_currentexp() {
		return father_currentexp;
	}


	public void setFather_currentexp(Double father_currentexp) {
		this.father_currentexp = father_currentexp;
	}


	public Long getRationcard_number() {
		return rationcard_number;
	}


	public void setRationcard_number(Long rationcard_number) {
		this.rationcard_number = rationcard_number;
	}


	public Long getAnnual_income() {
		return annual_income;
	}


	public void setAnnual_income(Long annual_income) {
		this.annual_income = annual_income;
	}


	public String getAccount_number() {
		return account_number;
	}


	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}


	public String getLaon_id() {
		return laon_id;
	}


	public void setLaon_id(String laon_id) {
		this.laon_id = laon_id;
	}
	
	
	
	
	
	
	

}
