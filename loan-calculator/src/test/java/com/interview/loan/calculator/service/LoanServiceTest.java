package com.interview.loan.calculator.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.interview.loan.calculator.dto.LoanInfoDto;
import com.interview.loan.calculator.entity.LoanInfoEntity;
import com.interview.loan.calculator.entity.LoanType;
import com.interview.loan.calculator.repository.LoanInfoRepository;
import com.interview.loan.calculator.repository.LoanTypeRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoanServiceTest {
	
	@InjectMocks
	private LoanServiceImpl loanService;
	
	@Mock
	private LoanTypeRepository loanTypeRepository;
	
	@Mock
	private LoanInfoRepository loanInfoRepository;
	
	LoanType loanTypeMock;
	
	LoanInfoEntity loanInfoEntityMock;
	
	LoanInfoDto loanInfoDto;
	
	@Before
	public void setup() {
		loanTypeMock = new LoanType();
		loanTypeMock.setLoanType("Edu");
		loanTypeMock.setLoanTypeDesc("Edu Loan");
		loanTypeMock.setLoanTypeProcessingFees(500);
		loanTypeMock.setLoanTypeId(1);
		
		loanInfoEntityMock = new LoanInfoEntity();
		loanInfoEntityMock.setApr(3.3);
		loanInfoEntityMock.setDob("02-3-1888");
		loanInfoEntityMock.setLoanAmount(800000);
		loanInfoEntityMock.setLoanerId(1);
		loanInfoEntityMock.setName("Tom");
		loanInfoEntityMock.setRate(8);
		loanInfoEntityMock.setSsn("456-489-2323");
		loanInfoEntityMock.setTerm(1095);
		loanInfoEntityMock.setLoanType(loanTypeMock);
		
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
	public void testAddNewLonner() {
		Mockito.when(loanTypeRepository.findByLoanType(Mockito.anyString())).thenReturn(loanTypeMock);
		Mockito.when(loanInfoRepository.save(Mockito.any(LoanInfoEntity.class))).thenReturn(loanInfoEntityMock);
		LoanInfoDto loanInfoDtoResponse= loanService.addNewLonner(loanInfoDto);
		Assert.assertTrue(Double.valueOf(loanInfoDtoResponse.getApr()).equals(loanInfoEntityMock.getApr()));
		
	}
	
	@Test
   public void testGetLonnerInfo() {
	   List<LoanInfoEntity> entityInfoList =new ArrayList<>();
	   entityInfoList.add(loanInfoEntityMock);
	   Mockito.when(loanInfoRepository.findBySsn(Mockito.anyString())).thenReturn(entityInfoList);
	   List<LoanInfoDto> response = loanService.getLonnerInfo("1234-6543-34532");
		Assert.assertTrue(Double.valueOf(response.get(0).getApr()).equals(loanInfoEntityMock.getApr()));

	}


}
