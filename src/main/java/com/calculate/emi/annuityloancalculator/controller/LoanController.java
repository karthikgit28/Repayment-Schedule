package com.calculate.emi.annuityloancalculator.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculate.emi.annuityloancalculator.calculator.LoanCalculator;
import com.calculate.emi.annuityloancalculator.entity.RepaymentSchedule;

@RestController
public class LoanController {

	@PostMapping("/schedule")
	public ResponseEntity<List<RepaymentSchedule>> calculateRepaymentSchedule(String loanAmount,String nominalRate,String duration) {
		List<RepaymentSchedule> scheduleList = null;
		if(true) {
			scheduleList = LoanCalculator.printAmortizationSchedule(Double.parseDouble(loanAmount),Double.parseDouble(nominalRate),
					Integer.parseInt(duration));
		}
		if(scheduleList != null && scheduleList.size()> 0) {
			return new ResponseEntity<List<RepaymentSchedule>>(scheduleList, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<RepaymentSchedule>>(HttpStatus.BAD_REQUEST);
		}
	}

}
