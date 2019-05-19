package com.majorperk.marketservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.majorperk.marketservice.model.SurveyResponse;
import com.majorperk.marketservice.repository.SurveyResponseRepository;
import com.majorperk.marketservice.service.SurveyResponseService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("response")
class SurveyResponseController {

	@Autowired
	SurveyResponseRepository surveyResponseRepository;

	@Autowired
	SurveyResponseService surveyResponseService;

	@ResponseBody
	@RequestMapping(value = "/save/{question}/{rating}", method = RequestMethod.POST, produces = "application/json")
	public SurveyResponse loadAllSurveys(@PathVariable String question, @PathVariable int rating) {
		return surveyResponseRepository.save(new SurveyResponse(question, rating));
	}

	@ResponseBody
	@RequestMapping(value = "/aggregate/{question}", method = RequestMethod.POST, produces = "application/json")
	public double aggregateResponseByQuestion(@PathVariable String question) {
		return surveyResponseService.getAggregateResponseByQuestion(question);
	}
}