package com.interview.loan.calculator.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoanInfoDto {
	private String name;
	private String ssn;
	private String dob;
	private int loanAmount;
	private double rate;
	private String loanType;
	private int term;
	private double apr;

}
