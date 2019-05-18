package com.majorperk.marketservice.service;

import static com.majorperk.marketservice.utils.Constants.DEFAULT_FOLDER;
import static com.majorperk.marketservice.utils.Constants.DEFAULT_SURVEY;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.majorperk.marketservice.model.Survey;
import com.majorperk.marketservice.repository.AccountRepository;
import com.majorperk.marketservice.repository.SurveyRepository;

@Service
public class SurveyService {

	@Autowired
	AmazonS3 s3client;

	@Autowired
	SurveyRepository surveyRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;

	public List<Survey> readS3Surveys() {
		S3Object s3object = s3client.getObject(bucket, DEFAULT_FOLDER + DEFAULT_SURVEY);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
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