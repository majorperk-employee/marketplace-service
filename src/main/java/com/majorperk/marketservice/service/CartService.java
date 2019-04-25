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

	public Cart addItem(Long cartId, Long itemId) {
		Cart cart = cartRepository.findById(cartId).get();
		RewardItem itemToAdd = rewardRepository.findById(itemId).get();
		
		cart.getItems().add(itemToAdd);
		cart.updateTotalCost(itemToAdd.getPrice());
		
		itemToAdd.getMeta().incrementPurchased();
		rewardRepository.save(itemToAdd);
		
		return cartRepository.save(cart);
	}

	public Cart removeItem(Long cartId, Long itemId) {
		Cart cart = cartRepository.findById(cartId).get();
		RewardItem itemToRemove = rewardRepository.findById(itemId).get();
		
		cart.getItems().remove(itemToRemove);
		cart.updateTotalCost(-itemToRemove.getPrice());
		
		return cartRepository.save(cart);
	}
	
	public Cart removeItems(Long cartId, List<Long> rewardItemIds) {
		Cart cart = cartRepository.findById(cartId).get();				
		List<RewardItem> itemsToRemove = rewardRepository.findAllById(rewardItemIds);
		
		cart.getItems().removeAll(itemsToRemove);
		itemsToRemove.forEach(item -> cart.updateTotalCost(-item.getPrice()));
		
		return cartRepository.save(cart);
	}

	public List<RewardItem> getContents(Long cartId) {
		Cart cart = cartRepository.findById(cartId).get();
		return cart.getItems();
	}
	
	public Cart getCart(Long cartId) {
		return cartRepository.findById(cartId).get();
	}
}