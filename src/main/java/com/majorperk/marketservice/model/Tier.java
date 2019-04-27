package com.majorperk.marketservice.model;

import javax.persistence.Entity;

@Entity
public class Tier {
	String currentTier;
	String nextTier;	
	
	double onTimeGoal;
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
	
	public double getOnTimeGoal() {
		return onTimeGoal;
	}
	
	public void setOnTimeGoal(double onTimeGoal) {
		this.onTimeGoal = onTimeGoal;
	}
	
	public int getTotalDaysGoal() {
		return totalDaysGoal;
	}
	
	public void setTotalDaysGoal(int totalDaysGoal) {
		this.totalDaysGoal = totalDaysGoal;
	}
}