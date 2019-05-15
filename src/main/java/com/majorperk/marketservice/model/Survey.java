package com.majorperk.marketservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.majorperk.marketservice.model.reward.RewardItem;

@Entity
@Table(name="survey")
public class Survey {
	@Id
	@GeneratedValue
	Long id;

	int period;
	String question;
	ArrayList<Integer> options = new ArrayList<Integer>();
	int response;
	
	public Survey() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<Integer> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<Integer> options) {
		this.options = options;
	}

	public int getResponse() {
		return response;
	}

	public void setResponse(int response) {
		this.response = response;
	}
}