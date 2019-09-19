package com.generator.plan.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneratedPlanRow {
	private double borrowerPaymentAmount;
	private LocalDate date;
	private double initialOutstandingPrincipal;
	private double interest;
	private double principal;
	private double remainingOutstandingPrincipal;
	
	public GeneratedPlanRow() {
	}

	public GeneratedPlanRow(double borrowerPaymentAmount, LocalDate date, double initialOutstandingPrincipal,
			double interest, double principal, double remainingOutstandingPrincipal) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
		this.date = date;
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
		this.interest = interest;
		this.principal = principal;
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}

	public double getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}

	public void setBorrowerPaymentAmount(double borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}

	public void setInitialOutstandingPrincipal(double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}

	public void setRemainingOutstandingPrincipal(double remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}

	@Override
	public String toString() {
		return "{borrowerPaymentAmount='" + borrowerPaymentAmount + "', date='" + date
				+ "', initialOutstandingPrincipal='" + initialOutstandingPrincipal + "', interest='" + interest
				+ "', principal='" + principal + "', remainingOutstandingPrincipal='" + remainingOutstandingPrincipal + "'}";
	}
	
}
