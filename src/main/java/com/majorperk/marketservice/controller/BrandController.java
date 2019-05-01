package com.majorperk.marketservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.majorperk.marketservice.model.reward.Brand;
import com.majorperk.marketservice.repository.BrandRepository;
import com.majorperk.marketservice.service.Loader;
import com.majorperk.marketservice.service.TangoRewardMapper;

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

    @Autowired
    private TangoRewardMapper tangoRewardMapper;

    @GetMapping("/catalog")
    public @Valid List<Brand> getCatalog(@RequestParam(value = "verbose", defaultValue="false", required = false) Boolean verbose) {
        try {
            return this.tangoRewardMapper.getCatalog(verbose);
        } catch (Exception e) {
            System.out.println("Unable to access TangoCard catalog :::" + e);
            return null;
        }
    }

    @GetMapping("/all")
    public @Valid List<?> getAllBrands(@RequestParam(value = "verbose", defaultValue="false", required = false) Boolean verbose) {
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

    @PostMapping("/load/custom")
    public @Valid List<Brand> createCustomRewardItems(@Valid @RequestBody List<Brand> rewardItem) {
        try {
            return brandRepository.saveAll(rewardItem);
        } catch (Exception e) {
            System.out.println("Unable to load custom objects to database." + e);
            return new ArrayList<Brand>();
        }
    }

    @PostMapping("/load/file")
    public @Valid String loadDefaultRewardItems() throws IOException {
        try {
            Loader rewardLoader = new Loader();
            brandRepository.saveAll(rewardLoader.createRewardsList(rewardLoader.readJSON("./src/main/resources/TangoCardRewards.json")));
            return  "Successful loading default catalog from JSON";
        } catch (Exception e) {
            System.out.println("Unable to load from JSON.");
            return "Unable to load default catalog from JSON"  + e;
        }
    }

    @PostMapping("/load")
    public @Valid Object loadCatalog() throws IOException {
        try {
            brandRepository.saveAll(this.tangoRewardMapper.getCatalog(false));
            return "Successful database load from API";
        } catch (Exception e) {
            System.out.println("Unable to load API Catalog. Attempting to load defaults ... ");
            this.loadDefaultRewardItems();
            return "Unable to load API Catalog. Attempting to load defaults ... " + e;
        }
    }
}