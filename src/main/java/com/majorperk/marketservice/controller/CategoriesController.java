package com.majorperk.marketservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.majorperk.marketservice.model.Category;
import com.majorperk.marketservice.repository.CategoryRepository;
import com.majorperk.marketservice.service.Loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("categories")
public class CategoriesController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    Loader categoriesLoader;

    @GetMapping("/all")
    public @Valid List<Category> getCategories() {
        try {
            return categoryRepository.findAll();
        } catch (Exception e) {
            System.out.println("Unable to get all categories.");
            return new ArrayList<Category>();
        }
    }

    @PostMapping("/load")
    public @Valid String loadCategories() throws IOException {
        try {
            categoryRepository.saveAll(categoriesLoader.getS3DefaultCategories());
            // categoryRepository.saveAll(categoriesLoader.createCategoriesList(categoriesLoader.readJSON("./src/main/resources/defaultCategories.json")));
            return "Successful loading default categories from S3";
        } catch (Exception e) {
            System.out.println("Unable to load default categories from S3 " + e);
            return "Unable to load default categories from S3" + e;
        }
    }
}