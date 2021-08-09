package com.interview.loan.calculator.service;

import java.util.List;

import com.interview.loan.calculator.dto.LoanInfoDto;

public interface LoanService {

	LoanInfoDto addNewLonner(LoanInfoDto loanInfoDto);

	List<LoanInfoDto> getLonnerInfo(String lonner);}
