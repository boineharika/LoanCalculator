package com.interview.loan.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.loan.calculator.entity.LoanType;

public interface LoanTypeRepository extends JpaRepository<LoanType, Long> {

	LoanType findByLoanType(String loanType);

}
