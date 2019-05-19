package com.majorperk.marketservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.majorperk.marketservice.model.SurveyResponse;
import com.majorperk.marketservice.repository.SurveyResponseRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("response")
public class SurveyResponseController {

	@Autowired
	SurveyResponseRepository surveyResponseRepository;

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public SurveyResponse loadAllSurveys(@RequestBody SurveyResponse response) {
		return surveyResponseRepository.save(response);
	}
}