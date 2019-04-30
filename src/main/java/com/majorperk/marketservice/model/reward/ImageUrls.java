package com.majorperk.marketservice.model.reward;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ImageUrls {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

    @JsonProperty("80w-326ppi")
    String xs;

    @JsonProperty("130w-326ppi")
    String s;

    @JsonProperty("200w-326ppi")
    String m;

    @JsonProperty("278w-326ppi")
    String l;
    
    @JsonProperty("300w-326ppi")
    String xl;
    
    @JsonProperty("1200w-326ppi")
    String xxl;

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
     * @return the xs
     */
    public String getXs() {
        return xs;
    }

    /**
     * @param xs the xs to set
     */
    public void setXs(String xs) {
        this.xs = xs;
    }

    /**
     * @return the s
     */
    public String getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(String s) {
        this.s = s;
    }

    /**
     * @return the m
     */
    public String getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(String m) {
        this.m = m;
    }

    /**
     * @return the l
     */
    public String getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(String l) {
        this.l = l;
    }

    /**
     * @return the xl
     */
    public String getXl() {
        return xl;
    }

    /**
     * @param xl the xl to set
     */
    public void setXl(String xl) {
        this.xl = xl;
    }

    /**
     * @return the xxl
     */
    public String getXxl() {
        return xxl;
    }

    /**
     * @param xxl the xxl to set
     */
    public void setXxl(String xxl) {
        this.xxl = xxl;
    }

}