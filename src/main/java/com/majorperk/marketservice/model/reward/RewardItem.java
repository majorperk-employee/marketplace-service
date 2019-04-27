package com.majorperk.marketservice.model.reward;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;;


@Entity
@Getter 
@Setter 
@NoArgsConstructor
public class RewardItem {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String utid;
	String rewardName;
	String currencyCode;
	String status;
	String valueType;
	String rewardType;
	String createdDate;
	String lastUpdateDate;
	
	@Column(length=10485760)
	String redemptionInstructions;
	
	Integer faceValue;
	Integer minValue;
	Integer maxValue;
	Boolean isWholeAmountValueRequired;

	@ManyToOne
    @JoinColumn
	Brand brand;

	Integer price;
	
	ArrayList<String> countries;
	ArrayList<String> credentialTypes;
	ArrayList<String> tags;

	@OneToOne(cascade = CascadeType.ALL)
	RewardItemMeta meta;

	public RewardItemMeta getMeta() {
		return this.meta;
	}

	public Integer getPrice() {
		return this.price;
	}

	public Long getId() {
		return this.id;
	}
	
}