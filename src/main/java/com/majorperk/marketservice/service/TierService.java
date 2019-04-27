package com.majorperk.marketservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.majorperk.marketservice.model.Account;

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
	
	public List<Account> updateTiers(List<Account> accountsToUpdate) {
		accountsToUpdate.forEach(account -> {
			account = updateTier(account);
		});
		
		return accountsToUpdate;		
	}

	private Account updateTier() {
		// TODO Auto-generated method stub
		return null;
	}

}