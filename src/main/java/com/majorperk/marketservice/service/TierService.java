package com.majorperk.marketservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.Tier;
import com.majorperk.marketservice.repository.AccountRepository;

import static com.majorperk.marketservice.utils.Constants.EMPLOYEE;

import static com.majorperk.marketservice.utils.Constants.PLATINUM;
import static com.majorperk.marketservice.utils.Constants.PLATINUM_DAYS;
import static com.majorperk.marketservice.utils.Constants.PLATINUM_PERCENT;

import static com.majorperk.marketservice.utils.Constants.GOLD;
import static com.majorperk.marketservice.utils.Constants.GOLD_DAYS;
import static com.majorperk.marketservice.utils.Constants.GOLD_PERCENT;

import static com.majorperk.marketservice.utils.Constants.SILVER;
import static com.majorperk.marketservice.utils.Constants.SILVER_DAYS;
import static com.majorperk.marketservice.utils.Constants.SILVER_PERCENT;

import static com.majorperk.marketservice.utils.Constants.EMPLOYEE_MULTIPLIER;
import static com.majorperk.marketservice.utils.Constants.SILVER_MULTIPLIER;
import static com.majorperk.marketservice.utils.Constants.GOLD_MULTIPLIER;
import static com.majorperk.marketservice.utils.Constants.PLATINUM_MULTIPLIER;

@Service
public class TierService {
	
	@Autowired
	private AccountRepository accountRepository;
	

	
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

			tier.setMultiplier(PLATINUM_MULTIPLIER);
		} else if(onTimeDays >= GOLD_DAYS && onTimePercent >= GOLD_PERCENT) {
			tier.setNextTier(PLATINUM);
			tier.setCurrentTier(GOLD);
			
			tier.setOnTimePercentGoal(PLATINUM_PERCENT);
			tier.setTotalDaysGoal(PLATINUM_DAYS);			

			tier.setMultiplier(GOLD_MULTIPLIER);
		} else if(onTimeDays >= SILVER_DAYS && onTimePercent >= SILVER_PERCENT) {
			tier.setNextTier(GOLD);
			tier.setCurrentTier(SILVER);
			
			tier.setOnTimePercentGoal(GOLD_PERCENT);
			tier.setTotalDaysGoal(GOLD_DAYS);

			tier.setMultiplier(SILVER_MULTIPLIER);
		} else {
			tier.setNextTier(SILVER);
			tier.setCurrentTier(EMPLOYEE);
			
			tier.setOnTimePercentGoal(SILVER_PERCENT);
			tier.setTotalDaysGoal(SILVER_DAYS);

			tier.setMultiplier(EMPLOYEE_MULTIPLIER);
		}
		return tier;
	}

}