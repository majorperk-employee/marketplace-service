package com.majorperk.marketservice.model.reward;

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
    

    public RewardItemMeta(Integer purchased,Integer selected) {
        this.purchased = purchased;
        this.selected = selected;
    }

    public void incrementSelected() {
        this.selected += 1;
    }

    public void incrementPurchased() {
		this.purchased += 1;
	}

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

    /**
     * @return the rewardItem
     */
    public RewardItem getRewardItem() {
        return rewardItem;
    }

    /**
     * @param rewardItem the rewardItem to set
     */
    public void setRewardItem(RewardItem rewardItem) {
        this.rewardItem = rewardItem;
    }

}