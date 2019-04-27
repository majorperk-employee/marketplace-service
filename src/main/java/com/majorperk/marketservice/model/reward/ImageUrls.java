package com.majorperk.marketservice.model.reward;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

}