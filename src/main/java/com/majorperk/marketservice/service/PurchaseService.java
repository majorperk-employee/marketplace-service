package com.majorperk.marketservice.service;

import static com.majorperk.marketservice.utils.Constants.TANGO_FIXED_VALUE;

import java.util.ArrayList;
import java.util.List;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.Purchase;
import com.majorperk.marketservice.model.reward.RewardItem;
import com.majorperk.marketservice.repository.AccountRepository;
import com.majorperk.marketservice.repository.RewardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RewardRepository rewardRepository;
	
	public List<Long> purchaseItems(Long userId) {
		Account account = accountRepository.findById(userId).get();

		if (account.getPoints() < account.getCart().getCost() ) {
			System.out.println(account.getId() + " insufficient funds.");
			return new ArrayList<>();
		}

		Purchase purchase = new Purchase();

		List<RewardItem> itemsToPurchase = account.getCart().getItems();
		
		List<Long> purchasedItemIds = new ArrayList<Long>();
		
		itemsToPurchase.forEach(item -> {
		
			Integer value = item.getFaceValue();

			if(!(item.getValueType()== TANGO_FIXED_VALUE)) {
				item.setFaceValue(null);
			}

			item.getMeta().incrementPurchased();
		
			rewardRepository.save(item);
		
			purchase.setCost(purchase.getCost() + item.getPrice());

			item.setFaceValue(value);
			
			purchase.addPurchaseItem(item);
		
			purchasedItemIds.add(item.getId());
		
		});

		account.addPurchase(purchase);
		
		accountRepository.save(account);

		return purchasedItemIds;
	}

	public List<Purchase> getPurchases(Long userId) {
		Account account = accountRepository.findById(userId).get();
		List<Purchase> purchases = account.getPurchases();
		return purchases;
	}
}