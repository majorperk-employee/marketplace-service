package com.majorperk.marketservice.controller;

import com.majorperk.marketservice.model.AccountSandP;
import com.majorperk.marketservice.service.CSVMapper;

import java.io.File;
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
class CSVController {
	
	@Autowired
	CSVMapper csvMapper;
	
	@GetMapping("/readSandPAccounts")
	public List<AccountSandP> readSandPAccounts() {
	  try {
		  File csvToRead = new File("./src/main/resources/S&P-Sample-Data-employees.csv");
		  return csvMapper.readCSV(csvToRead);
	  } catch (Exception e) {
		  	System.out.println("Unable to read csv file " + e);
		  return new ArrayList<AccountSandP>();
		  }
	  }
}