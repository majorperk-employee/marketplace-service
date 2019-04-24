package com.majorperk.marketservice.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.repository.AccountRepository;
import com.majorperk.marketservice.service.Loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/accounts/all")
    public @Valid List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    
    @GetMapping("/accounts/loadDefaultUsers")
    public @Valid List<Account> createDefaultRewardItems() throws IOException {
    	Loader userLoader = new Loader();
        return accountRepository.saveAll(userLoader.createAccountList(userLoader.readJSON("./src/main/resources/defaultAccounts.json")));
    }
}