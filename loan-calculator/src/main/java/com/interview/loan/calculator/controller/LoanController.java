package com.interview.loan.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.loan.calculator.dto.LoanInfoDto;
import com.interview.loan.calculator.entity.LoanInfoEntity;
import com.interview.loan.calculator.service.LoanService;

@RestController
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@PostMapping("/add-loaner")
	public LoanInfoDto addNewUser(@RequestBody LoanInfoDto lonner){
		LoanInfoDto newLonner = loanService.addNewLonner(lonner);
		return newLonner;
	}
	@GetMapping("/get-loaner/{ssn}")
	public List<LoanInfoDto> getLonnerInfo(@PathVariable ("ssn") String lonner ) {
		List<LoanInfoDto> lonnerInfo = loanService.getLonnerInfo(lonner);
		return lonnerInfo ;
	}
	
	

}
