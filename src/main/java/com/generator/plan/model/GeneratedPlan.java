package com.generator.plan.model;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneratedPlan {
	
	private ArrayList<GeneratedPlanRow> payments = new ArrayList<GeneratedPlanRow>();
	
	public void addRow(GeneratedPlanRow row) {
		payments.add(row);
	}

	public ArrayList<GeneratedPlanRow> getPayments() {
		return payments;
	}

	@Override
	public String toString() {
		return "GeneratedPlan {payments='" + payments + "'}";
	}

	
}
