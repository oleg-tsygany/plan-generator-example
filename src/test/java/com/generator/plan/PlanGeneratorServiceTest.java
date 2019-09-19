package com.generator.plan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.generator.plan.model.GeneratedPlan;
import com.generator.plan.model.PlanGenerationTask;

public class PlanGeneratorServiceTest {
	// Some basic test for business logic

	@Test
	public void PlanGeneratorServiceToCentsTest() {
		// Checking if rounding to cents work correct
		assertThat(PlanGeneratorService.toCents(0)).isEqualTo(0);
		assertThat(PlanGeneratorService.toCents(1.234)).isEqualTo(1.23);
		assertThat(PlanGeneratorService.toCents(123.456)).isEqualTo(123.46);
	}
	
	@Test
	public void PlanGeneratorServiceMonthlyInterestTest() {
		assertThat(PlanGeneratorService.monthlyInterest(0)).isEqualTo(0);
		assertThat(PlanGeneratorService.monthlyInterest(12)).isEqualTo(1);
	}
	
	@Test
	public void PlanGeneratorServiceAnnuityAmountTest() {
		assertThat(PlanGeneratorService.annuityAmount(0,0,0)).isEqualTo(0);
		assertThat(PlanGeneratorService.annuityAmount(5000.0,0.05,24)).isEqualTo(219.36);
	}
	
	@Test
	public void PlanGeneratorServiceInterestTest() {
		assertThat(PlanGeneratorService.interest(0,0)).isEqualTo(0);
		assertThat(PlanGeneratorService.interest(5000,0.05)).isEqualTo(20.83);
	}
	
	@Test
	public void PlanGeneratorServiceGenerateTest() {
		PlanGeneratorService service = new PlanGeneratorService();
		GeneratedPlan plan = service.generate(new PlanGenerationTask());
		assertThat(plan.toString()).isEqualTo("GeneratedPlan {payments='[]'}");
		
		plan = service.generate(new PlanGenerationTask(5000, 5, 1, LocalDate.of(2018, 1, 1)));
		assertThat(plan.toString()).isEqualTo("GeneratedPlan {payments='[{borrowerPaymentAmount='5020.83', date='2018-01-01', initialOutstandingPrincipal='5000.0', interest='20.83', principal='5000.0', remainingOutstandingPrincipal='0.0'}]'}");
	}
}
