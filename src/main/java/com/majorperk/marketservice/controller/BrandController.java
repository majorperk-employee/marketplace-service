package com.majorperk.marketservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import com.majorperk.marketservice.model.reward.Brand;
import com.majorperk.marketservice.repository.BrandRepository;
import com.majorperk.marketservice.service.Loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("brands")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping("/all")
    public @Valid Collection getAllBrands(@RequestParam(value = "verbose", defaultValue="false", required = false) Boolean verbose) {
        try {
            if (verbose) {
                return brandRepository.findAll();
            }
            return brandRepository.findAllCondensed();
        } catch (Exception e) {
            System.out.println("Unable to list all brands. Please verify database :::" + e);
            return null;
        }
    }

    // GET Brand
	@ResponseBody
	@RequestMapping(value = "getById/{id}", method = RequestMethod.GET, produces = "application/json")
    public Brand getBrandById(@PathVariable Long id) {
        try {
            return brandRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("Unable to find brand id: " + id + ". Please verify database :::" + e);
            return null;
        }
    }

    @PostMapping("/customLoad")
    public @Valid List<Brand> createCustomRewardItems(@Valid @RequestBody List<Brand> rewardItem) {
        try {
            return brandRepository.saveAll(rewardItem);
        } catch (Exception e) {
            System.out.println("Unable to load custom objects to database.");
            return new ArrayList<Brand>();
        }
    }

    @PostMapping("/defaultLoad")
    public @Valid List<Brand> createDefaultRewardItems() throws IOException {
        try {
            Loader rewardLoader = new Loader();
            return brandRepository.saveAll(rewardLoader.createRewardsList(rewardLoader.readJSON("./src/main/resources/TangoCardRewards.json")));
            // return rewardRepository.saveAll(rewardLoader.createRewardsList(rewardLoader.readJSON("./src/main/resources/defaultRewards.json")));
        } catch (Exception e) {
            System.out.println("Unable to load from JSON.");
            return new ArrayList<Brand>();
        }
    }
}