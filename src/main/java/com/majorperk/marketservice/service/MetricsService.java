package com.majorperk.marketservice.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.SandPMetrics;
import com.majorperk.marketservice.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

	@Autowired
	AccountRepository accountRepository;
	
	Random random = new Random();
	
    public List<SandPMetrics> readDefaultCSV() {
		try {
			File csvToRead = new File("./src/main/resources/S&P-Sample-Data-employees.csv");
			MappingIterator<SandPMetrics> personIter;
			personIter = new CsvMapper().readerWithTypedSchemaFor(SandPMetrics.class).readValues(csvToRead);
			return personIter.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<SandPMetrics>();
		}		
    }

	public void batchLoad() {
		List<SandPMetrics> metricsToLoad = readDefaultCSV();
		metricsToLoad.forEach(metric -> {
			Optional<Account> account = accountRepository.findById(metric.getEmployee_id());
			if(account.isPresent()) {
				Account accountToUpdate = account.get();
				accountToUpdate.setSAndPMetrics(metric);
				accountRepository.save(accountToUpdate);
			} else {
				Account newAccount = buildDefaultAccount(metric);
				accountRepository.save(newAccount);
			}
		});	
	}
	
	public Account buildDefaultAccount(SandPMetrics metrics) {
		Account defaultAccount = new Account();
		String userName = metrics.getLastname() + random.nextInt(2000);
		
		defaultAccount.setId(metrics.getEmployee_id());
		defaultAccount.setSAndPMetrics(metrics);
		defaultAccount.setPhone(null);
		defaultAccount.setNickname(null);
		defaultAccount.setUsername(userName);		
		defaultAccount.setPassword("defaultPassword");
		defaultAccount.setManager(false);
		defaultAccount.setEmail(null);
		defaultAccount.setPicture(null);
		defaultAccount.setPoints(0);
		
		return defaultAccount;
	}
}