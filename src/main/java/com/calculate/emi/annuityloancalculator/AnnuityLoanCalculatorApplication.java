package com.calculate.emi.annuityloancalculator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.calculate.emi.annuityloancalculator.calculator.LoanCalculator;

@SpringBootApplication
public class AnnuityLoanCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnuityLoanCalculatorApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		LoanCalculator calculate = new LoanCalculator();
//		calculate.calculateAmount();
//	}

}
