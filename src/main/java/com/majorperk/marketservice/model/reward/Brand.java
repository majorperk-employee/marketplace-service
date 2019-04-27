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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter 
@Setter 
@NoArgsConstructor
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

    
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    List<RewardItem> items;

    @OneToOne(cascade = CascadeType.ALL)
    Requirements brandRequirements;
	  
}