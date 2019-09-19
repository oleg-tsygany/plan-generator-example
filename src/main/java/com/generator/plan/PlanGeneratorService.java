package com.generator.plan;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.generator.plan.model.GeneratedPlan;
import com.generator.plan.model.GeneratedPlanRow;
import com.generator.plan.model.PlanGenerationTask;

@Service
public class PlanGeneratorService {
	
	public GeneratedPlan generate(PlanGenerationTask task) {
		GeneratedPlan plan = new GeneratedPlan();
		// Get initial data from task
		LocalDate payDate = task.getStartDate();
		double loanAmount = task.getLoanAmount();
		double initialOutstandingPrincipal = loanAmount;
		// since we get input as whole percents (f.e. 5%) we have to divide it to 100
		double nominalInterest = task.getNominalRate() / 100.0;
		long duration = task.getDuration();
		
		// Calculate annuity amount for this setup
		double annuityAmount = annuityAmount(loanAmount, nominalInterest, duration);
		
		// Creating plan
		for (int i = 0; i <duration; i++) {
			double interest = interest(initialOutstandingPrincipal, nominalInterest);
			double principal = annuityAmount - interest;
			if(principal > initialOutstandingPrincipal) principal = initialOutstandingPrincipal;
			double borrowerPaymentAmount = principal + interest;
			double remainingOutstandingPrincipal = initialOutstandingPrincipal - principal;
			
			GeneratedPlanRow row = new GeneratedPlanRow(
					toCents(borrowerPaymentAmount), payDate, toCents(initialOutstandingPrincipal), 
					toCents(interest), toCents(principal), toCents(remainingOutstandingPrincipal));
			plan.addRow(row);
			
			initialOutstandingPrincipal = remainingOutstandingPrincipal;
			payDate = payDate.plusMonths(1);
		}
		
		return plan;
	}
	
	
/*
 *  Private methods 
 */
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
}
