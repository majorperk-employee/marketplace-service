package com.majorperk.marketservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.Tier;

@Service
public class TierService {
	
	/*[Employee]
			[Silver] if > 60 days worked || > 85% on time
			[Gold] if > 90 days worked || > 90% on time
			[Platinum] if > 120 days worked || > 95% on time

			Input: User (totalDaysWorked, OnTimePercentage[tdw/totaldays])

			Return Tier Object:

			Current Tier,
			Next Tier,
			Goals: (OTP, TDW)*/
	
	public final String PLATINUM = "Platinum";
	public final String GOLD = "Gold";	
	public final String SILVER = "Silver";
	public final String EMPLOYEE = "Employee";
	
	public final double PLATINUM_PERCENT = .95;
	public final double GOLD_PERCENT = .90;	
	public final double SILVER_PERCENT = .85;
	
	public final int PLATINUM_DAYS = 120;
	public final int GOLD_DAYS = 90;	
	public final int SILVER_DAYS = 60;
	
	public List<Account> updateTiers(List<Account> accountsToUpdate) {
		accountsToUpdate.forEach(account -> {
			account.setTier(updateTier(account));
		});
		
		return accountsToUpdate;		
	}

	private Tier updateTier(Account account) {
		
		int totalDays = account.getTotaldays();
		double onTimePercent = account.getOntimedays() / totalDays;
		Tier tier = account.getTier();				
		
		// Should this be on time days (or maybe an && instead of ||) worked rather than just total days?
		// Otherwise all they need to do is work there for 4 months & they're
		// platinum, no matter how punctual they are.
		if(totalDays >= PLATINUM_DAYS && onTimePercent >= PLATINUM_PERCENT) {
			// What happens if they've reached max tier?
			tier.setNextTier(PLATINUM);
			tier.setCurrentTier(PLATINUM);
			
			tier.setOnTimePercentGoal(PLATINUM_PERCENT);
			tier.setTotalDaysGoal(PLATINUM_DAYS);
		} else if(totalDays >= GOLD_DAYS && onTimePercent >= GOLD_PERCENT) {
			tier.setNextTier(PLATINUM);
			tier.setCurrentTier(GOLD);
			
			tier.setOnTimePercentGoal(PLATINUM_PERCENT);
			tier.setTotalDaysGoal(PLATINUM_DAYS);
			
		} else if(totalDays >= SILVER_DAYS && onTimePercent >= SILVER_PERCENT) {
			tier.setNextTier(GOLD);
			tier.setCurrentTier(SILVER);
			
			tier.setOnTimePercentGoal(GOLD_PERCENT);
			tier.setTotalDaysGoal(GOLD_DAYS);
		} else {
			tier.setNextTier(SILVER);
			tier.setCurrentTier(EMPLOYEE);
			
			tier.setOnTimePercentGoal(GOLD_PERCENT);
			tier.setTotalDaysGoal(GOLD_DAYS);
		}
		
		return tier;
	}

}