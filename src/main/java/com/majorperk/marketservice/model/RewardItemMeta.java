package com.majorperk.marketservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class RewardItemMeta {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    Integer purchased;
	Integer selected;
    
    @OneToOne(mappedBy = "meta")
    private RewardItem rewardItem;

    /**
     * @return the purchased
     */
    public Integer getPurchased() {
        return purchased;
    }

    /**
     * @param purchased the purchased to set
     */
    public void setPurchased(Integer purchased) {
        this.purchased = purchased;
    }
    
	public void incrementPurchased() {
		this.purchased += 1;
	}

    /**
     * @return the selected
     */
    public Integer getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(Integer selected) {
        this.selected = selected;
    }
}