package com.interview.loan.calculator.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.interview.loan.calculator.dto.LoanInfoDto;
import com.interview.loan.calculator.service.LoanServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class LoanControllerTest {

	@InjectMocks
	LoanController loanController;

	@Mock
	LoanServiceImpl loanService;
	LoanInfoDto loanInfoDto;

	@Before
	public void setup() {
		loanInfoDto = new LoanInfoDto();
		loanInfoDto.setApr(3.3);
		loanInfoDto.setDob("02-3-1888");
		loanInfoDto.setLoanAmount(800000);
		loanInfoDto.setName("Tom");
		loanInfoDto.setRate(8);
		loanInfoDto.setSsn("456-489-2323");
		loanInfoDto.setTerm(1095);
		loanInfoDto.setLoanType("Edu");
	}

	@Test
	public void testAddNewUser() {
		Mockito.when(loanService.addNewLonner(Mockito.any(LoanInfoDto.class))).thenReturn(loanInfoDto);
		LoanInfoDto laDto = loanController.addNewUser(loanInfoDto);
		Assert.assertNotNull(laDto);
		Assert.assertTrue(laDto.getSsn().equals(loanInfoDto.getSsn()));
	}

	@Test
	public void testGeLoanerInfo() {
		List<LoanInfoDto> list = new ArrayList<>();
		list.add(loanInfoDto);
		Mockito.when(loanService.getLonnerInfo(Mockito.anyString())).thenReturn(list);
		List<LoanInfoDto> response = loanService.getLonnerInfo("1234-6543-34532");
		Assert.assertTrue(Double.valueOf(response.get(0).getApr()).equals(3.3));
	}
}
