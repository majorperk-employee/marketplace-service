package com.majorperk.marketservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	List<RewardItem> items;

	public Cart() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RewardItem> getCartItems() {
		return items;
	}

	public void setCartItems(List<RewardItem> cartItems) {
		this.items = cartItems;
	}

	public void addCartItem(RewardItem cartItem) {
		this.items.add(cartItem);
	}
}