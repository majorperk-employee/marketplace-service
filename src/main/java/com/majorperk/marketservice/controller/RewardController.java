package com.majorperk.marketservice.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.majorperk.marketservice.model.Category;
import com.majorperk.marketservice.model.RewardItem;
import com.majorperk.marketservice.repository.CategoryRepository;
import com.majorperk.marketservice.repository.RewardRepository;
import com.majorperk.marketservice.service.Loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RewardController {

    @Autowired
    private RewardRepository rewardRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/rewards/all")
    public @Valid List<RewardItem> getRewardItems() {
        return rewardRepository.findAll();
    }


    @PostMapping("/rewards/customLoad")
    public @Valid List<RewardItem> createCustomRewardItems(@Valid @RequestBody List<RewardItem> rewardItem) {
        return rewardRepository.saveAll(rewardItem);
    }
    
    @PostMapping("/rewards/defaultLoad")
    public @Valid List<RewardItem> createDefaultRewardItems() throws IOException {
    	Loader rewardLoader = new Loader();
        return rewardRepository.saveAll(rewardLoader.createRewardsList(rewardLoader.readJSON("./src/main/resources/defaultRewards.json")));
    }
    
    @GetMapping("/rewards/getCategories")
    public @Valid List<Category> getCategories() {
    	return categoryRepository.findAll();
    }
    
    @PostMapping("/rewards/loadDefaultCategories")
    public @Valid List<Category> loadCategories() throws IOException {
    	Loader categoriesLoader = new Loader();
    	return categoryRepository.saveAll(categoriesLoader.createCategoriesList(categoriesLoader.readJSON("./src/main/resources/defaultCategories.json")));
    }
}