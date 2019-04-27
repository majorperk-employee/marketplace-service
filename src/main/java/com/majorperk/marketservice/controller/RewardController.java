package com.majorperk.marketservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.majorperk.marketservice.model.Category;
import com.majorperk.marketservice.model.reward.RewardItem;
import com.majorperk.marketservice.repository.CategoryRepository;
import com.majorperk.marketservice.repository.RewardRepository;
import com.majorperk.marketservice.service.Loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("rewards")
public class RewardController {

    @Autowired
    private RewardRepository rewardRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    public @Valid List<RewardItem> getAllBrands() {
        try {
            return rewardRepository.findAll();
        } catch (Exception e) {
            System.out.println("Unable to list all rewards items. Please verify database.");
            return new ArrayList<RewardItem>();
        }
    }


    @PostMapping("/customLoad")
    public @Valid List<RewardItem> createCustomRewardItems(@Valid @RequestBody List<RewardItem> rewardItem) {
        try {
            return rewardRepository.saveAll(rewardItem);
        } catch (Exception e) {
            System.out.println("Unable to load custom objects to database.");
            return new ArrayList<RewardItem>();
        }
    }
    
    @GetMapping("/getCategories")
    public @Valid List<Category> getCategories() {
        try {
            return categoryRepository.findAll();
        } catch (Exception e) {
            System.out.println("Unable to get all categories.");
            return new ArrayList<Category>();
        }
    }
    
    @PostMapping("/loadDefaultCategories")
    public @Valid List<Category> loadCategories() throws IOException {
        try {
            Loader categoriesLoader = new Loader();
            return categoryRepository.saveAll(categoriesLoader.createCategoriesList(categoriesLoader.readJSON("./src/main/resources/defaultCategories.json")));
        } catch (Exception e) {
            System.out.println("Unable to load categories from JSON.");
            return new ArrayList<Category>();
        }
    }
}