package com.majorperk.marketservice.model.reward;

import javax.persistence.Column;
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
public class Requirements {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "brandRequirements")
    private Brand brand;

    @Column(length=10485760)
    String displayInstructions;

    @Column(length=10485760)
    String termsAndConditionsInstructions;

    @Column(length=10485760)
    String disclaimerInstructions;

    Boolean alwaysShowDisclaimer;

}