package com.majorperk.marketservice.model.reward;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@NoArgsConstructor
public class RewardItemMeta {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    Integer purchased;
	Integer selected;
    
    @OneToOne(mappedBy = "meta")
    private RewardItem rewardItem;
    
    public void incrementSelected() {
        this.selected += 1;
    }

    public void incrementPurchased() {
		this.purchased += 1;
	}

}