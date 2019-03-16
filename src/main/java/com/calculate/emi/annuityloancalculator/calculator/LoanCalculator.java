package com.calculate.emi.annuityloancalculator.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.calculate.emi.annuityloancalculator.entity.RepaymentSchedule;

@Component
public class LoanCalculator {

	Logger log = LoggerFactory.getLogger(LoanCalculator.class.getName());

	public void calculateAmount() {	
		Scanner sc = new Scanner(System.in);
		// Prompt the user for loan amount, number of years and annual interest rate
		System.out.println("Enter Loan amount");
		double loanAmount = sc.nextDouble();

		System.out.print("Number of Years: ");
		int numYears = sc.nextInt();

		System.out.print("Annual Interest Rate (in %): ");
		double annualInterestRate = sc.nextDouble();

		System.out.println();  
		//Print the repayment schedule
		printAmortizationSchedule(loanAmount, annualInterestRate, numYears);
	}

	/**
	 * Prints amortization schedule for all months.
	 * @param principal - the total amount of the loan
	 * @param annualInterestRate in percent
	 * @param numYears
	 */
	public static List<RepaymentSchedule> printAmortizationSchedule(double principal, double annualInterestRate,
			int numYears) {
		double interestPaid, principalPaid, newBalance;
		double monthlyInterestRate, monthlyPayment;
		int month;
		int numMonths = numYears * 12;
		List<RepaymentSchedule> scheduleList = new ArrayList<RepaymentSchedule>();
		RepaymentSchedule schedule = null;

		// Output monthly payment and total payment
		monthlyInterestRate = annualInterestRate / 12;
		monthlyPayment      = monthlyPayment(principal, monthlyInterestRate, numYears);

		// Print the table header
		printTableHeader();

		for (month = 1; month <= numMonths; month++) {
			// Compute amount paid and new balance for each payment period
			interestPaid  = principal      * (monthlyInterestRate / 100);
			principalPaid = monthlyPayment - interestPaid;
			newBalance    = principal      - principalPaid;

			schedule = new RepaymentSchedule();
			schedule.setAmountPaid(monthlyPayment);
			schedule.setInterestPaid(interestPaid);
			schedule.setPrincipalPaid(principalPaid);
			schedule.setOutstandingPrincipal(newBalance);
			// Output the data item
			printScheduleItem(monthlyPayment, interestPaid, principalPaid, newBalance);

			// Update the balance
			principal = newBalance;
			scheduleList.add(schedule);
		}
		return scheduleList;
	}

	/**
	 * @param loanAmount
	 * @param monthlyInterestRate in percent
	 * @param numberOfYears
	 * @return the amount of the monthly payment of the loan
	 */
	static double monthlyPayment(double loanAmount, double monthlyInterestRate, int numberOfYears) {
		monthlyInterestRate /= 100;  // e.g. 5% => 0.05
		return loanAmount * monthlyInterestRate /
				( 1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12) );
	}

	/**
	 * Prints a table data of the amount Reschedule as a table row.
	 */
	private static void printScheduleItem(double monthlyPayment, double interestPaid,
			double principalPaid, double newBalance) {
		System.out.format("%8f%10.2f%10.2f%12.2f\n",
				monthlyPayment, interestPaid, principalPaid, newBalance);
	}

	/**
	 * Prints the table header for the  Re-schedule.
	 */
	private static void printTableHeader() {
		 System.out.println("\nRe-schedule Data");
		for(int i = 0; i < 40; i++) {  // Draw a line
			System.out.print("-");
		}
		System.out.format("\n%10s%10s%15s%15s\n",
				"Annuity#", "Interest", "Principal", "Remaining Outstanding");
		System.out.format("%8s%10s%10s%12s\n\n",
				"", "paid", "paid", "");
	}


}
