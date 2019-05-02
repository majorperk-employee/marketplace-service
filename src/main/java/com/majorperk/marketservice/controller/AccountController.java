package com.majorperk.marketservice.controller;

import java.io.IOException;
import java.util.List;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.repository.AccountRepository;
import com.majorperk.marketservice.service.Loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

class Auth {
  Long id;
  Integer points;

  public Auth(Long id, Integer points) {
    this.id = id;
    this.points = points;
  }
}

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("accounts")
public class AccountController {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  Loader userLoader;

  @GetMapping("/health")
  public Integer getHealth() {
    return 200;
  }

  @GetMapping("/all")
  public List<Account> getAllAccounts() {
    return accountRepository.findAll();
  }

  @GetMapping("/load/file")
  public String createDefaultRewardItems() throws IOException {
    try {
      accountRepository.saveAll(userLoader.getS3DefaultAccounts());
      // accountRepository.saveAll(userLoader.createAccountList(userLoader.readJSON("./src/main/resources/defaultAccounts.json")));
      return "Successful loading default accounts from S3";
    } catch (Exception e) {
      System.out.println("Unable to load from JSON.");
      return "Unable to load default accounts from S3 " + e;
    }
  }

  @GetMapping("/username/{username}")
  public Account getAccountById(@PathVariable String username) {
    return accountRepository.findByUsername(username);
  }

  @GetMapping("/id/{id}")
  public Account getAccountById(@PathVariable Long id) {
    return accountRepository.findById(id).get();
  }

  @GetMapping("/getAuth/{id}")
  public Object getAuth(@PathVariable Long id) {
    Account account = accountRepository.findById(id).get();
    return new Auth(account.getId(), account.getPoints());
  }

  @PostMapping("/update")
  public Account updateUser(Account userToUpdate) {
    return accountRepository.save(userToUpdate);
  }
}