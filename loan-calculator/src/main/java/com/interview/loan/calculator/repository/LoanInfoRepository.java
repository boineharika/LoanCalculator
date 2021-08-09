package com.interview.loan.calculator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.loan.calculator.entity.LoanInfoEntity;

@Repository
public interface LoanInfoRepository extends JpaRepository<LoanInfoEntity, Long> {

/*	LoanerInfo saveNewUser(LoanerInfo user);
*/


	List<LoanInfoEntity> findBySsn(String name);
	
}