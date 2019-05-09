package com.majorperk.marketservice.controller;

import com.majorperk.marketservice.model.SandPMetrics;
import com.majorperk.marketservice.repository.SandPMetricsRepository;
import com.majorperk.marketservice.service.CSVMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("csv")
class SandPMetricsController {
	
	@Autowired
	SandPMetricsRepository sAndPMetricsRepository;
	
	@Autowired
	CSVMapper csvMapper;
	
	@GetMapping("/readSandPMetrics")
	public List<SandPMetrics> readSandPAccounts() {
	  try {		  
		  return csvMapper.readDefaultCSV();
	  } catch (Exception e) {
		  	System.out.println("Unable to read csv file " + e);
		  return new ArrayList<SandPMetrics>();
	  }
	}
	
	@GetMapping("/loadSandPMetrics")
	public String loadSandPAccounts() {
		try {
			sAndPMetricsRepository.saveAll(csvMapper.readDefaultCSV());
			return "Successful loading of SandPAccounts";
		} catch (Exception e) {
			return "Exception encountered loading S and P Accounts " + e;
		}
	}
	
	@GetMapping("/getAllSandPMetrics")
	public List<SandPMetrics> getAllSandPAccounts() {
			return sAndPMetricsRepository.findAll();		
	}
}