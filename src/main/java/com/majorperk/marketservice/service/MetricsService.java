package com.majorperk.marketservice.service;

import static com.majorperk.marketservice.utils.Constants.DEFAULT_FOLDER;
import static com.majorperk.marketservice.utils.Constants.S_AND_P_EMPLOYEES;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.model.SandPMetrics;
import com.majorperk.marketservice.repository.AccountRepository;

@Service
public class MetricsService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
    AmazonS3 s3client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
	
	Random random = new Random();
    
    public List<SandPMetrics> readS3Metrics() {
		S3Object s3object = s3client.getObject(bucket, DEFAULT_FOLDER + S_AND_P_EMPLOYEES);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		
		try {
			MappingIterator<SandPMetrics> personIter;
			personIter = new CsvMapper().readerWithTypedSchemaFor(SandPMetrics.class).readValues(inputStream);
			return personIter.readAll();
		} catch (Exception e) {
			inputStream.abort();
			System.out.println("Error getting s3 file 'defaultAccounts.json' ::: " + e);
			return null;
		}
    }

	public void batchLoad() {
		List<SandPMetrics> metricsToLoad = readS3Metrics();
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
		defaultAccount.setPassword("password");
		defaultAccount.setManager(false);
		defaultAccount.setEmail(null);
		defaultAccount.setPicture(null);
		defaultAccount.setPoints(0);
		
		return defaultAccount;
	}
}