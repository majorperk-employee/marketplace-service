package com.majorperk.marketservice.model;

import javax.persistence.Entity;

@Entity
public class Tier {
	String currentTier;
	String nextTier;	
	
	double onTimePercentGoal;
	int totalDaysGoal;

	public String getCurrentTier() {
		return currentTier;
	}
	public void setCurrentTier(String currentTier) {
		this.currentTier = currentTier;
	}
	
	public String getNextTier() {
		return nextTier;
	}
	
	public void setNextTier(String nextTier) {
		this.nextTier = nextTier;
	}
	
	public double getOnTimePercentGoal() {
		return onTimePercentGoal;
	}
	
	public void setOnTimePercentGoal(double onTimeGoal) {
		this.onTimePercentGoal = onTimeGoal;
	}
	
	public int getTotalDaysGoal() {
		return totalDaysGoal;
	}
	
	public void setTotalDaysGoal(int totalDaysGoal) {
		this.totalDaysGoal = totalDaysGoal;
	}
}