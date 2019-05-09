package com.majorperk.marketservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.Cart;
import com.majorperk.marketservice.model.reward.RewardItem;
import com.majorperk.marketservice.repository.AccountRepository;
import com.majorperk.marketservice.repository.CartRepository;
import com.majorperk.marketservice.repository.RewardRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private RewardRepository rewardRepository;

	@Autowired
	private AccountRepository accountRepository;

	Integer cartCost = 0;

	public Cart addItem(Long userId, Long itemId, Integer price) {

		Account account = accountRepository.findById(userId).get();

		Cart cart  = account.getCart();
		
		RewardItem itemToAdd = rewardRepository.findById(itemId).get();

		itemToAdd.setFaceValue(price);

		itemToAdd.setPrice(price * account.getTier().getMultiplier());
		
		cart.getItems().add(itemToAdd);
		
		cart.setCost(updateCost(cart));

		itemToAdd.getMeta().incrementSelected();


		rewardRepository.save(itemToAdd);
		
		return cartRepository.save(cart);
	}
	
	public Cart removeItems(Long userId, List<Long> itemIDsToRemove) {

		Long cartId = accountRepository.findById(userId).get().getCart().getId();
		
		Cart cart = cartRepository.findById(cartId).get();				
		
		List<RewardItem> itemsToRemove = rewardRepository.findAllById(itemIDsToRemove);

		cart.getItems().removeAll(itemsToRemove);		
		
		cart.setCost(updateCost(cart));

		return cartRepository.save(cart);
	}

	private Integer updateCost(Cart cart) {
		cartCost = 0;
		cart.getItems().forEach(item -> {
			cartCost += item.getPrice();
		});
		return cartCost;
	}

	public List<RewardItem> getContents(Long userId) {
		
		Long cartId = accountRepository.findById(userId).get().getCart().getId();
		
		Cart cart = cartRepository.findById(cartId).get();		

		cart.setCost(updateCost(cart));

		return cart.getItems();
	}
	
	public Cart getCart(Long userId) {

		Long cartId = accountRepository.findById(userId).get().getCart().getId();

		return cartRepository.findById(cartId).get();
	}

	public Cart getCartByUser(Long userId) {
		Account account = accountRepository.findById(userId).get();
		return cartRepository.findById(account.getCart().getId()).get();
	}
}