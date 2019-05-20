package com.majorperk.marketservice.controller;

import java.util.List;

import javax.validation.Valid;

import com.majorperk.marketservice.model.reward.Brand;
import com.majorperk.marketservice.service.TangoRewardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("rewardlink")
class RewardLinkController {

	@Autowired
	private TangoRewardService tangoRewardService;

    @GetMapping("/view")
	public @Valid List<Brand> getCatalog() {
		try {
			return null; //RETURN REWARDLINK ITEM HERE
		} catch (Exception e) {
			System.out.println("Unable to access TangoCard catalog :::" + e);
			return null;
		}
	}

	@GetMapping("/catalog")
	public @Valid List<Brand> getCatalog(
			@RequestParam(value = "verbose", defaultValue = "false", required = false) Boolean verbose) {
		try {
			return this.tangoRewardService.getCatalog(verbose);
		} catch (Exception e) {
			System.out.println("Unable to access TangoCard catalog :::" + e);
			return null;
		}
	}

    // Checkout
    @ResponseBody
    @RequestMapping(value = "/redeem/{userid}", method = RequestMethod.POST, produces = "application/json")
    Object redeemRewardLink(@PathVariable Long userid, @RequestBody int amount) {
        try {
            return tangoRewardService.redeemRewardLink(userid, amount);
        } catch (Exception e) {
            System.out.println("Unable to complete rewardLink redemption for " + userid + " " + e);
            return null;
        }
	}
	
}