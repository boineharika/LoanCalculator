package com.interview.loan.calculator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "loaner_info")
@Entity
public class LoanInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name="loan_id")
	private long loanerId;
	private String name;
	private String ssn;
	private String dob;
	private int loanAmount;
	private double rate;	
	private int term;
	private double apr;
	//@ManyToMany(cascade=CascadeType.ALL, mappedBy="loanInfoEntity")
	//@PrimaryKeyJoinColumn
	
	 //@ManyToOne(cascade = CascadeType.MERGE)//
    //@JoinTable(name = "loan_type", joinColumns = @JoinColumn(name = "loan_id"), inverseJoinColumns = @JoinColumn(name = "loan_type_id"))
	// @JoinColumn(name = "loan_type",referencedColumnName = "loan_type")
	 @OneToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "loan_type_id")
	private LoanType loanType;

}
