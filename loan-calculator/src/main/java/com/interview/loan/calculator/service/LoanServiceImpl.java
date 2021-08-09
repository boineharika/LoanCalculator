package com.interview.loan.calculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.loan.calculator.dto.LoanInfoDto;
import com.interview.loan.calculator.entity.LoanInfoEntity;
import com.interview.loan.calculator.entity.LoanType;
import com.interview.loan.calculator.repository.LoanInfoRepository;
import com.interview.loan.calculator.repository.LoanTypeRepository;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanInfoRepository userRepository;
	
	@Autowired
	LoanTypeRepository loanTypeRepository;
	
	
   @Override
	public LoanInfoDto addNewLonner(LoanInfoDto loanInfoDto) {
		LoanType loanType = loanTypeRepository.findByLoanType(loanInfoDto.getLoanType());
		double interest = loanInfoDto.getLoanAmount() * loanInfoDto.getRate() * (loanInfoDto.getTerm() / 100);
		double apr = ((((loanType.getLoanTypeProcessingFees() + interest) / loanInfoDto.getLoanAmount()) / loanInfoDto.getTerm()) * 365) * 100;
		loanInfoDto.setApr(apr);
		LoanInfoEntity loanEntity = convertDtoToEntity(loanInfoDto);
		loanEntity.setLoanType(loanType);
		LoanInfoEntity savedLoanEntity = userRepository.save(loanEntity);
		LoanInfoDto loanInfo = convertEntityToDto(savedLoanEntity);
		return loanInfo;

	}

	@Override
	public List<LoanInfoDto> getLonnerInfo(String lonner) {
		List<LoanInfoEntity> loanInfoEntities = userRepository.findBySsn(lonner);
		List<LoanInfoDto> loanInfoDtos = new ArrayList();
		for (LoanInfoEntity loanInfoEntity : loanInfoEntities) {
			loanInfoDtos.add(convertEntityToDto(loanInfoEntity));
		}
		return loanInfoDtos;
	}

	private LoanInfoDto convertEntityToDto(LoanInfoEntity savedLoanEntity) {
		LoanInfoDto loanInfoDto = new LoanInfoDto();
		loanInfoDto.setApr(savedLoanEntity.getApr());
		loanInfoDto.setDob(savedLoanEntity.getDob());
		loanInfoDto.setLoanAmount(savedLoanEntity.getLoanAmount());
		loanInfoDto.setLoanType(savedLoanEntity.getLoanType().getLoanType());
		loanInfoDto.setName(savedLoanEntity.getName());
		loanInfoDto.setRate(savedLoanEntity.getRate());
		loanInfoDto.setSsn(savedLoanEntity.getSsn());
		loanInfoDto.setTerm(savedLoanEntity.getTerm());
		return loanInfoDto;
	}


	private LoanInfoEntity convertDtoToEntity(LoanInfoDto loanInfoDto) {
		LoanInfoEntity loanInfoEntity = new LoanInfoEntity();
		loanInfoEntity.setApr(loanInfoDto.getApr());
		loanInfoEntity.setDob(loanInfoDto.getDob());
		loanInfoEntity.setLoanAmount(loanInfoDto.getLoanAmount());
		loanInfoEntity.setName(loanInfoDto.getName());
		loanInfoEntity.setRate(loanInfoDto.getRate());
		loanInfoEntity.setSsn(loanInfoDto.getSsn());
		loanInfoEntity.setTerm(loanInfoDto.getTerm());
		return loanInfoEntity;
	}

}
