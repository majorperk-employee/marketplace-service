package com.majorperk.marketservice.service;

import static com.majorperk.marketservice.utils.Constants.EMPLOYEE;
import static com.majorperk.marketservice.utils.Constants.GOLD;
import static com.majorperk.marketservice.utils.Constants.GOLD_DAYS;
import static com.majorperk.marketservice.utils.Constants.GOLD_PERCENT;
import static com.majorperk.marketservice.utils.Constants.PLATINUM;
import static com.majorperk.marketservice.utils.Constants.PLATINUM_DAYS;
import static com.majorperk.marketservice.utils.Constants.PLATINUM_PERCENT;
import static com.majorperk.marketservice.utils.Constants.SILVER;
import static com.majorperk.marketservice.utils.Constants.SILVER_DAYS;
import static com.majorperk.marketservice.utils.Constants.SILVER_PERCENT;

import static com.majorperk.marketservice.utils.Constants.SILVER_MULTIPLIER;
import static com.majorperk.marketservice.utils.Constants.EMPLOYEE_MULTIPLIER;
import static com.majorperk.marketservice.utils.Constants.GOLD_MULTIPLIER;
import static com.majorperk.marketservice.utils.Constants.PLATINUM_MULTIPLIER;

import java.util.List;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.Tier;
import com.majorperk.marketservice.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		int totalDays = (int) (account.getSAndPMetrics().getProd_hours()/8);		
		double absenteeism = account.getSAndPMetrics().getAbstenteeism();
		double onTimeDays = totalDays * absenteeism;
		
		Tier tier = account.getTier();
		
		if(onTimeDays >= PLATINUM_DAYS && absenteeism >= PLATINUM_PERCENT) {
			tier.setNextTier(PLATINUM);
			
			tier.setCurrentTier(PLATINUM);
			tier.setMultiplier(PLATINUM_MULTIPLIER);

			tier.setabsenteeismGoal(absenteeism);
			tier.setTotalDaysGoal(totalDays);
		} else if(onTimeDays >= GOLD_DAYS && absenteeism >= GOLD_PERCENT) {
			tier.setNextTier(PLATINUM);
			
			tier.setCurrentTier(GOLD);
			tier.setMultiplier(GOLD_MULTIPLIER);

			tier.setabsenteeismGoal(PLATINUM_PERCENT);
			tier.setTotalDaysGoal(PLATINUM_DAYS);
		} else if(onTimeDays >= SILVER_DAYS && absenteeism >= SILVER_PERCENT) {
			tier.setNextTier(GOLD);

			tier.setCurrentTier(SILVER);
			tier.setMultiplier(SILVER_MULTIPLIER);

			tier.setabsenteeismGoal(GOLD_PERCENT);
			tier.setTotalDaysGoal(GOLD_DAYS);
		} else {
			tier.setNextTier(SILVER);
			
			tier.setCurrentTier(EMPLOYEE);
			tier.setMultiplier(EMPLOYEE_MULTIPLIER);

			tier.setabsenteeismGoal(SILVER_PERCENT);
			tier.setTotalDaysGoal(SILVER_DAYS);
		}
		return tier;
	}
}