package com.majorperk.marketservice.model.reward;

public class SmallBrand {

    Long id;

    String brandKey;
    String brandName;
    String status;
    
    String shortDescription;
    
    ImageUrls imageUrls;

    public SmallBrand(Long id, String brandKey, String brandName, String status, String shortDescription, ImageUrls imageUrls) {
        this.id = id;
        this.brandKey = brandKey;
        this.brandName = brandName;
        this.status = status;
        this.shortDescription = shortDescription;
        this.imageUrls = imageUrls;
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

}