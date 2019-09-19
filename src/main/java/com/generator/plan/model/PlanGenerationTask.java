package com.generator.plan.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanGenerationTask {
	private double loanAmount;
	private double nominalRate;
	private long duration;
	private LocalDate startDate;
	
	public PlanGenerationTask() {
	}

	public PlanGenerationTask(double loanAmount, double nominalRate, long duration, LocalDate startDate) {
		this.loanAmount = loanAmount;
		this.nominalRate = nominalRate;
		this.duration = duration;
		this.startDate = startDate;
	}

	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getNominalRate() {
		return nominalRate;
	}
	public void setNominalRate(double nominalRate) {
		this.nominalRate = nominalRate;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	@Override
    public String toString() {
        return "PlanGenerationTask {" +
                "loanAmount='" + loanAmount + '\'' +
                ", nominalRate='" + nominalRate +'\'' +
                ", duration='" + duration +'\'' +
                ", startDate='" + startDate.toString() +'\'' +
                '}';
	}
}
