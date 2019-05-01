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
@Table(name="purchase")
public class Purchase extends AuditModel {
	@Id
	@GeneratedValue
	Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	List<RewardItem> items = new ArrayList<RewardItem>();

	Integer cost = 0;

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

	/**
	 * @return the cost
	 */
	public Integer getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
	}

}