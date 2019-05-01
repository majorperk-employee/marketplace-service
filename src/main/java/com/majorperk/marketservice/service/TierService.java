package com.majorperk.marketservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.Tier;
import com.majorperk.marketservice.repository.AccountRepository;

@Service
public class TierService {
	
	@Autowired
	private AccountRepository accountRepository;
	
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
		
		return accountRepository.saveAll(accountsToUpdate);		
	}

	private Tier updateTier(Account account) {
		
		int totalDays = account.getTotaldays();
		double onTimeDays = account.getOntimedays();
		double onTimePercent = account.getOntimedays() / totalDays;
		Tier tier = account.getTier();				
		
		if(onTimeDays >= PLATINUM_DAYS && onTimePercent >= PLATINUM_PERCENT) {
			tier.setNextTier(PLATINUM);
			tier.setCurrentTier(PLATINUM);
			
			tier.setOnTimePercentGoal(onTimePercent);
			tier.setTotalDaysGoal(totalDays);
		} else if(onTimeDays >= GOLD_DAYS && onTimePercent >= GOLD_PERCENT) {
			tier.setNextTier(PLATINUM);
			tier.setCurrentTier(GOLD);
			
			tier.setOnTimePercentGoal(PLATINUM_PERCENT);
			tier.setTotalDaysGoal(PLATINUM_DAYS);			
		} else if(onTimeDays >= SILVER_DAYS && onTimePercent >= SILVER_PERCENT) {
			tier.setNextTier(GOLD);
			tier.setCurrentTier(SILVER);
			
			tier.setOnTimePercentGoal(GOLD_PERCENT);
			tier.setTotalDaysGoal(GOLD_DAYS);
		} else {
			tier.setNextTier(SILVER);
			tier.setCurrentTier(EMPLOYEE);
			
			tier.setOnTimePercentGoal(SILVER_PERCENT);
			tier.setTotalDaysGoal(SILVER_DAYS);
		}
		return tier;
	}

}