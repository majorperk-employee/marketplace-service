package com.majorperk.marketservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorperk.marketservice.model.Cart;
import com.majorperk.marketservice.model.RewardItem;
import com.majorperk.marketservice.repository.CartRepository;
import com.majorperk.marketservice.repository.RewardRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private RewardRepository rewardRepository;

	Integer cartCost = 0;

	public Cart addItem(Long cartId, Long itemId) {
		Cart cart = cartRepository.findById(cartId).get();
		RewardItem itemToAdd = rewardRepository.findById(itemId).get();
		
		cart.getItems().add(itemToAdd);
		
		cart.setCost(updateCost(cart));
		
		itemToAdd.getMeta().incrementPurchased();
		rewardRepository.save(itemToAdd);
		
		return cartRepository.save(cart);
	}
	
	public Cart removeItems(Long cartId, List<Long> rewardItemIds) {
		Cart cart = cartRepository.findById(cartId).get();				
		List<RewardItem> itemsToRemove = rewardRepository.findAllById(rewardItemIds);
		
		cart.getItems().removeAll(itemsToRemove);
		
		cart.setCost(updateCost(cart));

		return cartRepository.save(cart);
	}

	private Integer updateCost(Cart cart) {
		cartCost = 0;
		
		cart.getItems().forEach(item -> {
			System.out.println(item.getId());
			cartCost += item.getPrice();
		});

		return cartCost;
	}

	public List<RewardItem> getContents(Long cartId) {
		
		Cart cart = cartRepository.findById(cartId).get();

		cart.setCost(updateCost(cart));

		return cart.getItems();
	}
	
	public Cart getCart(Long cartId) {
		return cartRepository.findById(cartId).get();
	}
}