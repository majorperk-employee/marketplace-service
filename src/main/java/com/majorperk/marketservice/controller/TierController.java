package com.majorperk.marketservice.controller;

import com.majorperk.marketservice.model.Tier;
import com.majorperk.marketservice.repository.AccountRepository;
import com.majorperk.marketservice.service.TierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("tier")
class TierController {


	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	TierService tierService;

	@ResponseBody
	@RequestMapping(value = "/update/tiers", method = RequestMethod.POST, produces = "application/json")
	void updateAllAccountTiers() {
		try {
			tierService.updateTiers(accountRepository.findAll());
		} catch (Exception e) {
			System.out.println("Unable to complete tier uppdate");
		}
	}
	
	  @GetMapping("/user/{id}")
	  public Tier getTierById(@PathVariable long id) {
		  try {
			  return accountRepository.findById(id).get().getTier();	  
		  } catch (Exception e) {
				System.out.println("Unable to complete tier update for " + id);
				return new Tier();
		  }	    
	  }
}