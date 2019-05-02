package com.majorperk.marketservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

	String name;
	
	@ElementCollection
	List<String> brandIds;
	
	public Category() {
		super();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the brandIds
	 */
	public List<String> getBrandIds() {
		return brandIds;
	}

	/**
	 * @param brandIds the brandIds to set
	 */
	public void setBrandIds(List<String> brandIds) {
		this.brandIds = brandIds;
	}

}
