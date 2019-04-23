package com.majorperk.marketservice.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class RewardItem {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	String name;
	String type;
	String imageURL;
    String description;
	
	Integer price;
	
	ArrayList<String> tags;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "item_meta", 
		joinColumns = { @JoinColumn(name = "rewardItem_id", referencedColumnName = "id") }, 
		inverseJoinColumns = { @JoinColumn(name = "metaData_id", referencedColumnName = "id") })
	RewardItemMeta meta;


	public RewardItem() {
		super();
	}

	public RewardItem(String name, Integer price, String category, String description, String tags, String image,
			Boolean incart) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

    public RewardItemMeta getMeta() {
        return meta;
    }

	public void setMeta(RewardItemMeta meta) {
		this.meta = meta;
	}

	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}