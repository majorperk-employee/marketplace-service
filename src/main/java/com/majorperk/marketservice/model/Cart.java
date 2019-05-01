package com.majorperk.marketservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.majorperk.marketservice.model.reward.RewardItem;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue
	Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	List<RewardItem> items = new ArrayList<RewardItem>();
	
	int cost;

	public Cart() {
		super();
	}

	public Cart(int cost) {
		this.cost = -1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RewardItem> getItems() {
		return items;
	}

	public void setItems(List<RewardItem> items) {
		this.items = items;
	}

	public void addCartItem(RewardItem item) {
		this.items.add(item);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}