package com.interview.loan.calculator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "loan_type")
@Entity
public class LoanType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name="loan_type_id")
	private long loanTypeId;
	private String loanType;
	private String loanTypeDesc;
	private int loanTypeProcessingFees;
	
	/*@ManyToMany
	@MapsId
	@JoinColumn(name="loaner_id")
	private LoanInfoEntity loanInfoEntity;*/
	
}
