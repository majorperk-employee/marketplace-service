package com.majorperk.marketservice.model;

import javax.persistence.Entity;

@Entity
public class Tier {
	String currentTier;
	String nextTier;	
	
	int onTimeGoal;
	int totalDaysGoal;
	// Create factory for tiers. Accept user with tier and run logic on it
	// to determine their tier.
}
