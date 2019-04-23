package com.majorperk.marketservice.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.majorperk.marketservice.model.Category;
import com.majorperk.marketservice.model.RewardItem;
import com.majorperk.marketservice.utils.ReadJson;

@Service
public class Loader {

	public String readJSON(String pathToRead) throws IOException {
		ReadJson readJson = new ReadJson();		
		File directory = new File(pathToRead);
		return readJson.readFileAsString(directory.getAbsolutePath());
	}

	public List<RewardItem> createRewardsList(String jsonRewardList) throws IOException {
		List<RewardItem> rewardItems = new ArrayList<RewardItem>();
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			rewardItems = jsonMapper.readValue(jsonRewardList, new TypeReference<List<RewardItem>>() { });
		} catch (JsonProcessingException e) {
			// Definitely a hand written auto catch block.
			e.printStackTrace();
		}
		return rewardItems;
	}

	public List<Category> createCategoriesList(String jsonCategoryList) throws IOException {
		List<Category> categories = new ArrayList<Category>();
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			categories = jsonMapper.readValue(jsonCategoryList, new TypeReference<List<Category>>() { });
		} catch (JsonProcessingException e) {
			// Definitely a hand written auto catch block.
			e.printStackTrace();
		}
		return categories;
	}
}