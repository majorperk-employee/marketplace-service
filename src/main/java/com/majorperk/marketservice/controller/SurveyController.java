package com.majorperk.marketservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.majorperk.marketservice.model.Survey;
import com.majorperk.marketservice.service.SurveyService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("survey")
class SurveyController {

	@Autowired
	SurveyService surveyService;

	@ResponseBody
	@RequestMapping(value = "/load/default", method = RequestMethod.POST, produces = "application/json")
	public List<Survey> loadAllSurveys() {
		return surveyService.loadDefaultSurveys();
	}

	@GetMapping("/user/{userId}")
	public List<Survey> getSurveysByUser(@PathVariable long userId) {
		return surveyService.getSurveysByUserId(userId);
	}
}