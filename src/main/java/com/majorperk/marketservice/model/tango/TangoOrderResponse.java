package com.majorperk.marketservice.model.tango;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="rewardlinks")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TangoOrderResponse {

    @Id
    String referenceOrderID;

    String utid;
    String rewardName;
    String status;
    String createdAt;

    String redemptionLink;

    @Column(length=10485760)
    String redemptionInstructions;

    int total;
    String currencyCode;

    @JsonProperty("reward")
    private void unpackRedemptionInstruction(Map<String, Object> reward) {
        redemptionInstructions = (String) reward.get("redemptionInstructions");
        Map<String,String> credentials = (Map<String,String>)reward.get("credentials");
        redemptionLink = credentials.get("Redemption Link");
    }

    @JsonProperty("amountCharged")
    private void unpackAmountCharged(Map<String, Object> amountCharged) {
        Double temp = (Double) amountCharged.get("total");
        total = temp.intValue();
        currencyCode = (String)amountCharged.get("currencyCode");
    }

    public TangoOrderResponse() {
        super();
    }

    public String getReferenceOrderID() {
        return referenceOrderID;
    }

    public void setReferenceOrderID(String referenceOrderID) {
        this.referenceOrderID = referenceOrderID;
    }

    public String getUtid() {
        return utid;
    }

    public void setUtid(String utid) {
        this.utid = utid;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getRedemptionLink() {
        return redemptionLink;
    }

    public void setRedemptionLink(String redemptionLink) {
        this.redemptionLink = redemptionLink;
    }

    public String getRedemptionInstructions() {
        return redemptionInstructions;
    }

    public void setRedemptionInstructions(String redemptionInstructions) {
        this.redemptionInstructions = redemptionInstructions;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}