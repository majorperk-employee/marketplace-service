package com.majorperk.marketservice.model;

import java.util.List;

import com.majorperk.marketservice.model.reward.Brand;

public class Catalog {
    String catalogName;
    List<Brand> brands;

    /**
     * @return the catalogName
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * @param catalogName the catalogName to set
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    /**
     * @return the brands
     */
    public List<Brand> getBrands() {
        return brands;
    }

    /**
     * @param brands the brands to set
     */
    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }
}