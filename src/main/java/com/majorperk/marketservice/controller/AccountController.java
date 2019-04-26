package com.majorperk.marketservice.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.repository.AccountRepository;
import com.majorperk.marketservice.service.Loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    
    @GetMapping("/loadDefaultUsers")
    public List<Account> createDefaultRewardItems() throws IOException {
    	Loader userLoader = new Loader();
        return accountRepository.saveAll(userLoader.createAccountList(userLoader.readJSON("./src/main/resources/defaultAccounts.json")));
    }
    
    @GetMapping("/getByUsername") 
    public Account getAccountById(@RequestParam(value = "username", required = true) String username) {
		return accountRepository.findByUsername(username);
    }
    
    @GetMapping("/getById")
    public Optional<Account> getAccountById(@RequestParam(value = "id", required = true) Long id) {
		return accountRepository.findById(id);
    }
}