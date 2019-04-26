package com.majorperk.marketservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Purchase extends AuditModel {
	@Id
	@GeneratedValue
	Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	List<RewardItem> items;

	public Purchase() {
		super();
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

	public void addPurchaseItem(RewardItem item) {
		this.items.add(item);
	}
}