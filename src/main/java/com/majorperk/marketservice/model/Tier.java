package com.majorperk.marketservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tier")
public class Tier {
	
	@Id
	@GeneratedValue
	Long id;
	
	String currentTier;
	String nextTier;	
	
	double absenteeismGoal;
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
	
	public double getabsenteeismGoal() {
		return absenteeismGoal;
	}
	
	public void setabsenteeismGoal(double absenteeismGoal) {
		this.absenteeismGoal = absenteeismGoal;
	}
	
	public int getTotalDaysGoal() {
		return totalDaysGoal;
	}
	
	public void setTotalDaysGoal(int totalDaysGoal) {
		this.totalDaysGoal = totalDaysGoal;
	}
}