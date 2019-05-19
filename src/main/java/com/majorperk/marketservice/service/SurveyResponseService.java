package com.majorperk.marketservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majorperk.marketservice.model.SurveyResponse;
import com.majorperk.marketservice.repository.SurveyResponseRepository;

@Service
public class SurveyResponseService {

	@Autowired
	SurveyResponseRepository surveyResponseRepository;
	double averageRating = 0;

	public double getAggregateResponseByQuestion(String question) {
		List<SurveyResponse> surveyResponses = surveyResponseRepository.findAllByQuestion(question);

		surveyResponses.forEach(response -> {
			averageRating += response.getRating();
		});
		return averageRating / surveyResponses.size();
	}
}
