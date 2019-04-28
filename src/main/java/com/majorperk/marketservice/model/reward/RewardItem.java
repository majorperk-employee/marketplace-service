package com.majorperk.marketservice.model.reward;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import static com.majorperk.marketservice.utils.Constants.USD_PTS_CONVERSION;

import lombok.NoArgsConstructor;;


@Entity
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

	Integer price;
	
	ArrayList<String> countries;
	ArrayList<String> credentialTypes;
	ArrayList<String> tags;

	@OneToOne(cascade = CascadeType.ALL)
	RewardItemMeta meta;

	public RewardItemMeta getMeta() {
		if (this.meta == null) {
			return new RewardItemMeta(0,0);
		}
		return this.meta;
	}

	public Integer getPrice() {
		return this.faceValue * USD_PTS_CONVERSION;
	}

	public Long getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the utid
	 */
	public String getUtid() {
		return utid;
	}

	/**
	 * @param utid the utid to set
	 */
	public void setUtid(String utid) {
		this.utid = utid;
	}

	/**
	 * @return the rewardName
	 */
	public String getRewardName() {
		return rewardName;
	}

	/**
	 * @param rewardName the rewardName to set
	 */
	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the valueType
	 */
	public String getValueType() {
		return valueType;
	}

	/**
	 * @param valueType the valueType to set
	 */
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	/**
	 * @return the rewardType
	 */
	public String getRewardType() {
		return rewardType;
	}

	/**
	 * @param rewardType the rewardType to set
	 */
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the redemptionInstructions
	 */
	public String getRedemptionInstructions() {
		return redemptionInstructions;
	}

	/**
	 * @param redemptionInstructions the redemptionInstructions to set
	 */
	public void setRedemptionInstructions(String redemptionInstructions) {
		this.redemptionInstructions = redemptionInstructions;
	}

	/**
	 * @return the faceValue
	 */
	public Integer getFaceValue() {
		return faceValue;
	}

	/**
	 * @param faceValue the faceValue to set
	 */
	public void setFaceValue(Integer faceValue) {
		this.faceValue = faceValue;
	}

	/**
	 * @return the minValue
	 */
	public Integer getMinValue() {
		return minValue;
	}

	/**
	 * @param minValue the minValue to set
	 */
	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	/**
	 * @return the maxValue
	 */
	public Integer getMaxValue() {
		return maxValue;
	}

	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * @return the isWholeAmountValueRequired
	 */
	public Boolean getIsWholeAmountValueRequired() {
		return isWholeAmountValueRequired;
	}

	/**
	 * @param isWholeAmountValueRequired the isWholeAmountValueRequired to set
	 */
	public void setIsWholeAmountValueRequired(Boolean isWholeAmountValueRequired) {
		this.isWholeAmountValueRequired = isWholeAmountValueRequired;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the countries
	 */
	public ArrayList<String> getCountries() {
		return countries;
	}

	/**
	 * @param countries the countries to set
	 */
	public void setCountries(ArrayList<String> countries) {
		this.countries = countries;
	}

	/**
	 * @return the credentialTypes
	 */
	public ArrayList<String> getCredentialTypes() {
		return credentialTypes;
	}

	/**
	 * @param credentialTypes the credentialTypes to set
	 */
	public void setCredentialTypes(ArrayList<String> credentialTypes) {
		this.credentialTypes = credentialTypes;
	}

	/**
	 * @return the tags
	 */
	public ArrayList<String> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	/**
	 * @param meta the meta to set
	 */
	public void setMeta(RewardItemMeta meta) {
		this.meta = meta;
	}
	
}