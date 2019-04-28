package com.majorperk.marketservice.model.reward;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String brandKey;
    String brandName;
    String createdDate;
    String lastUpdateDate;
    String status;
    
    @Column(length=10485760)
    String terms;
    
    @Column(length=10485760)
    String disclaimer;
    
    @Column(length=10485760)
    String shortDescription;
    
    @Column(length=10485760)
    String description;

    @OneToOne(cascade = CascadeType.ALL)
    ImageUrls imageUrls;

    
    @OneToMany(cascade = CascadeType.ALL)
    List<RewardItem> items;

    @OneToOne(cascade = CascadeType.ALL)
    Requirements brandRequirements;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the brandKey
     */
    public String getBrandKey() {
        return brandKey;
    }

    /**
     * @param brandKey the brandKey to set
     */
    public void setBrandKey(String brandKey) {
        this.brandKey = brandKey;
    }

    /**
     * @return the brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName the brandName to set
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
     * @return the terms
     */
    public String getTerms() {
        return terms;
    }

    /**
     * @param terms the terms to set
     */
    public void setTerms(String terms) {
        this.terms = terms;
    }

    /**
     * @return the disclaimer
     */
    public String getDisclaimer() {
        return disclaimer;
    }

    /**
     * @param disclaimer the disclaimer to set
     */
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    /**
     * @return the shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * @param shortDescription the shortDescription to set
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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

    /**
     * @return the imageUrls
     */
    public ImageUrls getImageUrls() {
        return imageUrls;
    }

    /**
     * @param imageUrls the imageUrls to set
     */
    public void setImageUrls(ImageUrls imageUrls) {
        this.imageUrls = imageUrls;
    }

    /**
     * @return the items
     */
    public List<RewardItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<RewardItem> items) {
        this.items = items;
    }

    /**
     * @return the brandRequirements
     */
    public Requirements getBrandRequirements() {
        return brandRequirements;
    }

    /**
     * @param brandRequirements the brandRequirements to set
     */
    public void setBrandRequirements(Requirements brandRequirements) {
        this.brandRequirements = brandRequirements;
    }
	  
}