package com.majorperk.marketservice.service;

import static com.majorperk.marketservice.utils.Constants.DEFAULT_ACCOUNTS;
import static com.majorperk.marketservice.utils.Constants.DEFAULT_BRANDS;
import static com.majorperk.marketservice.utils.Constants.DEFAULT_CATEGORIES;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.Category;
import com.majorperk.marketservice.model.reward.Brand;
import com.majorperk.marketservice.utils.ReadJson;
import com.majorperk.marketservice.utils.ReadS3Bucket;

@Service
@PropertySource("classpath:application.yml")
public class Loader {

	@Autowired
	ReadS3Bucket readS3Bucket;

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
		ObjectMapper jsonMapper = new ObjectMapper();
		S3ObjectInputStream inputStream = readS3Bucket.readS3FileAsStream(DEFAULT_CATEGORIES);
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
		ObjectMapper jsonMapper = new ObjectMapper();
		S3ObjectInputStream inputStream = readS3Bucket.readS3FileAsStream(DEFAULT_ACCOUNTS);
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
		ObjectMapper jsonMapper = new ObjectMapper();
		S3ObjectInputStream inputStream = readS3Bucket.readS3FileAsStream(DEFAULT_BRANDS);
		try {
			List<Brand> brands = jsonMapper.readValue(inputStream, new TypeReference<List<Brand>>() {
			});
			System.out.println("Brands! " + brands.size());
			return brands;
		} catch (Exception e) {
			inputStream.abort();
			System.out.println("Error getting s3 file 'TangoCardRewards.json' ::: " + e);
			return null;
		}
	}
}