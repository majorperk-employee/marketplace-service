package com.majorperk.marketservice.service;

import static com.majorperk.marketservice.utils.Constants.DEFAULT_ACCOUNTS;
import static com.majorperk.marketservice.utils.Constants.DEFAULT_CATEGORIES;
import static com.majorperk.marketservice.utils.Constants.DEFAULT_FOLDER;
import static com.majorperk.marketservice.utils.Constants.DEFAULT_BRANDS;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.Category;
import com.majorperk.marketservice.model.reward.Brand;
import com.majorperk.marketservice.utils.ReadJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.yml")
public class Loader {

	@Autowired
    AmazonS3 s3client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

	public String readJSON(String pathToRead) throws IOException {
		ReadJson readJson = new ReadJson();
		File directory = new File(pathToRead);
		return readJson.readFileAsString(directory.getAbsolutePath());
	}

	// CATEGORIES

	public List<Category> createCategoriesList(String jsonCategoryList) throws IOException {
		List<Category> categories = new ArrayList<Category>();
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			categories = jsonMapper.readValue(jsonCategoryList, new TypeReference<List<Category>>() {
			});
		} catch (JsonProcessingException e) {
			// Definitely a hand written auto catch block.
			e.printStackTrace();
		}
		return categories;
	}

	public List<Category> getS3DefaultCategories() {
		S3Object s3object = s3client.getObject(bucket, DEFAULT_FOLDER + DEFAULT_CATEGORIES);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			List<Category> categories = jsonMapper.readValue(inputStream, new TypeReference<List<Category>>() {
			});
			return categories;
		} catch (Exception e) {
			inputStream.abort();
			System.out.println("Error getting s3 file 'defaultCategories.json' ::: " + e);
			return null;
		}
	}

	// ACCOUNTS

	public List<Account> createAccountList(String jsonAccountList) throws IOException {
		List<Account> accounts = new ArrayList<Account>();
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			accounts = jsonMapper.readValue(jsonAccountList, new TypeReference<List<Account>>() {
			});
		} catch (JsonProcessingException e) {
			// Definitely a hand written auto catch block.
			e.printStackTrace();
		}
		return accounts;
	}

	public List<Account> getS3DefaultAccounts() {
		S3Object s3object = s3client.getObject(bucket, DEFAULT_FOLDER + DEFAULT_ACCOUNTS);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			List<Account> accounts = jsonMapper.readValue(inputStream, new TypeReference<List<Account>>() {
			});
			return accounts;
		} catch (Exception e) {
			inputStream.abort();
			System.out.println("Error getting s3 file 'defaultAccounts.json' ::: " + e);
			return null;
		}
	}

	// BRANDS

	public List<Brand> createBrandsList(String jsonRewardList) throws IOException {
		List<Brand> rewardItems = new ArrayList<Brand>();
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			rewardItems = jsonMapper.readValue(jsonRewardList, new TypeReference<List<Brand>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return rewardItems;
	}

	public List<Brand> getS3DefaultBrands() {
		S3Object s3object = s3client.getObject(bucket, DEFAULT_FOLDER + DEFAULT_BRANDS);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		ObjectMapper jsonMapper = new ObjectMapper();

		try {
			List<Brand> brands = jsonMapper.readValue(inputStream, new TypeReference<List<Brand>>() {});
			return brands;
		} catch (Exception e) {
			inputStream.abort();
			System.out.println("Error getting s3 file 'TangoCardRewards.json' ::: " + e);
			return null;
		}
	}
}