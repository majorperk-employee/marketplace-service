package com.majorperk.marketservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.Order;
import com.majorperk.marketservice.model.RewardItem;
import com.majorperk.marketservice.repository.AccountRepository;
import com.majorperk.marketservice.repository.RewardRepository;

@Service
public class OrderService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RewardRepository rewardRepository;
	
	public void orderItems(Long userId, List<Long> rewardItemIds) {		
		Account account = accountRepository.findById(userId).get();
		Order order = new Order();
		
		List<RewardItem> itemsToOrder = rewardRepository.findAllById(rewardItemIds);
		itemsToOrder.forEach(item -> order.addOrderItem(item));
		account.addOrder(order);
	}

}