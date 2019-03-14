package com.calculate.emi.annuityloancalculator.entity;

public class RepaymentSchedule {
	
	private double amountPaid;
	private double interestPaid;
	private double principalPaid;
	private double outstandingPrincipal;
	
	public RepaymentSchedule() {
		
	}
	
	public RepaymentSchedule(double amountPaid, double interestPaid, double principalPaid,
			double outstandingPrincipal) {
		super();
		this.amountPaid = amountPaid;
		this.interestPaid = interestPaid;
		this.principalPaid = principalPaid;
		this.outstandingPrincipal = outstandingPrincipal;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public double getInterestPaid() {
		return interestPaid;
	}
	public void setInterestPaid(double interestPaid) {
		this.interestPaid = interestPaid;
	}
	public double getPrincipalPaid() {
		return principalPaid;
	}
	public void setPrincipalPaid(double principalPaid) {
		this.principalPaid = principalPaid;
	}
	public double getOutstandingPrincipal() {
		return outstandingPrincipal;
	}
	public void setOutstandingPrincipal(double outstandingPrincipal) {
		this.outstandingPrincipal = outstandingPrincipal;
	}
	
	@Override
	public String toString() {
		return "RepaymentSchedule [amountPaid=" + amountPaid + ", interestPaid=" + interestPaid + ", principalPaid="
				+ principalPaid + ", outstandingPrincipal=" + outstandingPrincipal + "]";
	}
	
	

}
