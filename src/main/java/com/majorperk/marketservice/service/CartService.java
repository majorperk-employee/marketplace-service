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
		return cartRepository.save(cart);
	}

	public Cart removeItem(Long cartId, Long itemId) {
		Cart cart = cartRepository.findById(cartId).get();
		RewardItem itemToRemove = rewardRepository.findById(itemId).get();
		cart.getItems().remove(itemToRemove);
		return cartRepository.save(cart);
	}

	public List<RewardItem> getContents(Long cartId) {
		Cart cart = cartRepository.findById(cartId).get();
		return cart.getItems();
	}
}