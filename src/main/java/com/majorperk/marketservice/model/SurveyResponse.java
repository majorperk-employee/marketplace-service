package com.majorperk.marketservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "response")
public class SurveyResponse {
	@Id
	@GeneratedValue
	Long id;

	String question;
	int rating;

	public SurveyResponse() {
		super();
	}

	public SurveyResponse(String question, int rating) {
		this.question = question;
		this.rating = rating;
	}
}