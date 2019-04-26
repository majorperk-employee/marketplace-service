package com.majorperk.marketservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.Purchase;
import com.majorperk.marketservice.model.RewardItem;
import com.majorperk.marketservice.repository.AccountRepository;
import com.majorperk.marketservice.repository.RewardRepository;

@Service
public class PurchaseService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RewardRepository rewardRepository;
	
	public void purchaseItems(Long userId, List<Long> rewardItemIds) {		
		Account account = accountRepository.findById(userId).get();
		Purchase purchase = new Purchase();
		
		List<RewardItem> itemsToPurchase = rewardRepository.findAllById(rewardItemIds);
		itemsToPurchase.forEach(item -> purchase.addPurchaseItem(item));
		account.addPurchase(purchase);
		
		accountRepository.save(account);
	}
}