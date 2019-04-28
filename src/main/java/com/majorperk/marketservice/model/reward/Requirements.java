package com.majorperk.marketservice.model.reward;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Requirements {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length=10485760)
    String displayInstructions;

    @Column(length=10485760)
    String termsAndConditionsInstructions;

    @Column(length=10485760)
    String disclaimerInstructions;

    Boolean alwaysShowDisclaimer;

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
     * @return the displayInstructions
     */
    public String getDisplayInstructions() {
        return displayInstructions;
    }

    /**
     * @param displayInstructions the displayInstructions to set
     */
    public void setDisplayInstructions(String displayInstructions) {
        this.displayInstructions = displayInstructions;
    }

    /**
     * @return the termsAndConditionsInstructions
     */
    public String getTermsAndConditionsInstructions() {
        return termsAndConditionsInstructions;
    }

    /**
     * @param termsAndConditionsInstructions the termsAndConditionsInstructions to
     *                                       set
     */
    public void setTermsAndConditionsInstructions(String termsAndConditionsInstructions) {
        this.termsAndConditionsInstructions = termsAndConditionsInstructions;
    }

    /**
     * @return the disclaimerInstructions
     */
    public String getDisclaimerInstructions() {
        return disclaimerInstructions;
    }

    /**
     * @param disclaimerInstructions the disclaimerInstructions to set
     */
    public void setDisclaimerInstructions(String disclaimerInstructions) {
        this.disclaimerInstructions = disclaimerInstructions;
    }

    /**
     * @return the alwaysShowDisclaimer
     */
    public Boolean getAlwaysShowDisclaimer() {
        return alwaysShowDisclaimer;
    }

    /**
     * @param alwaysShowDisclaimer the alwaysShowDisclaimer to set
     */
    public void setAlwaysShowDisclaimer(Boolean alwaysShowDisclaimer) {
        this.alwaysShowDisclaimer = alwaysShowDisclaimer;
    }

}