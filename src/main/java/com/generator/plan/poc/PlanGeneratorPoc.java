package com.generator.plan.poc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Console application to check Proof Of Concept (POC)
 * Later methods from this app was moved to PlangGeneratorService
*/
public class PlanGeneratorPoc {
	public static double toCents(double money) {
		return Math.round(money * 100.0) / 100.0;
	}

	public static double monthlyInterest(double interest) {
		return interest / 12.0;
	}
	
	public static double annuityAmount(double loanAmount, double interest, long duration) {
		double monthlyInterest = monthlyInterest(interest);
		double annuity = loanAmount / ((1 - Math.pow(1 + monthlyInterest, -duration)) / monthlyInterest);
		return toCents(annuity);
	}
	
	public static double interest(double initialOutstandingPrincipal, double nominalRate) {
		return toCents((nominalRate * 30.0 * initialOutstandingPrincipal) / 360.0);
	}
	
	public static void main(String[] args) {
		LocalDate payDate = LocalDate.of(2018, 01, 01);
		
		double loanAmount = 5000.0;
		double initialOutstandingPrincipal = loanAmount;
		double nominalInterest = 0.05;
		long duration = 24;
		
		double annuityAmount = annuityAmount(loanAmount, nominalInterest, duration);
		System.out.printf("annuityAmount: %.2f€\n", annuityAmount);
		
		for (int i = 0; i <duration; i++) {
			double interest = interest(initialOutstandingPrincipal, nominalInterest);
			double principal = annuityAmount - interest;
			if(principal > initialOutstandingPrincipal) principal = initialOutstandingPrincipal;
			double borrowerPaymentAmount = principal + interest;
			double remainingOutstandingPrincipal = initialOutstandingPrincipal - principal;

			System.out.printf("%s %7.2f€ %7.2f€ %5.2f€ %7.2f€ %7.2f€\n", payDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), 
					borrowerPaymentAmount, principal, interest, initialOutstandingPrincipal, remainingOutstandingPrincipal);
			
			initialOutstandingPrincipal = remainingOutstandingPrincipal;
			payDate = payDate.plusMonths(1);
		}
	}
}
