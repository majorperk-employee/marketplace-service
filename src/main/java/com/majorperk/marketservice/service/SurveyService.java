package com.majorperk.marketservice.service;

import static com.majorperk.marketservice.utils.Constants.DEFAULT_SURVEY;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.majorperk.marketservice.model.Survey;
import com.majorperk.marketservice.repository.AccountRepository;
import com.majorperk.marketservice.repository.SurveyRepository;
import com.majorperk.marketservice.utils.ReadS3Bucket;

@Service
public class SurveyService {
	@Autowired
	ReadS3Bucket readS3Bucket;

	@Autowired
	SurveyRepository surveyRepository;

	@Autowired
	private AccountRepository accountRepository;

	public List<Survey> readS3Surveys() {
		S3ObjectInputStream inputStream = readS3Bucket.readS3FileAsStream(DEFAULT_SURVEY);
		ObjectMapper jsonMapper = new ObjectMapper();

		try {
			return jsonMapper.readValue(inputStream, new TypeReference<List<Survey>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<Survey>();
		}
	}

	public List<Survey> loadDefaultSurveys() {
		return surveyRepository.saveAll(readS3Surveys());
	}

	public List<Survey> getSurveysByPeriod(int period) {
		return surveyRepository.findByPeriod(period);
	}

	public List<Survey> getSurveysForUser(long userId) {
		double prodHours = accountRepository.findById(userId).get().getSAndPMetrics().getProd_hours();
		return surveyRepository.findByPeriod(calculateSurveyPeriod(prodHours));
	}

	private int calculateSurveyPeriod(double prodHours) {
		if (prodHours < 9) {
			return 0;
		} else if (prodHours > 8 && prodHours < 41) {
			return 1;
		} else if (prodHours > 79 && prodHours < 160) {
			return 2;
		} else if (prodHours > 159 && prodHours < 320) {
			return 3;
		} else if (prodHours > 319 && prodHours < 480) {
			return 4;
		} else {
			return 5;
		}
	}
}