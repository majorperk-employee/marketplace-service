package com.majorperk.marketservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.majorperk.marketservice.model.reward.Brand;
import com.majorperk.marketservice.repository.BrandRepository;
import com.majorperk.marketservice.service.TangoRewardService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("rewardlink")
class RewardLinkController {

	@Autowired
	private TangoRewardService tangoRewardService;

	@Autowired
	private BrandRepository brandRepository;

	private static String brandKey = "B077325";
	private static String rewardLinkText = "Reward Link Preferred";

	@GetMapping("/view")
	public @Valid Brand getRewardLinkItem() {
		try {
			Brand brandKeyResponse = brandRepository.findOneByBrandKey(brandKey);
			if (brandKeyResponse != null && brandKeyResponse.getBrandName().contains(rewardLinkText)) {
				return brandKeyResponse;
			}
			Brand brandNameResponse = brandRepository.findOneByBrandName(rewardLinkText);
			if (brandNameResponse != null) {
				return brandNameResponse;
			} else {
				return new Brand();
			}
		} catch (Exception e) {
			System.out.println("Unable to access TangoCard catalog :::" + e);
			return new Brand();
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
	Object redeemRewardLink(@PathVariable Long userid) {
		try {
			return tangoRewardService.redeemRewardLink(userid);
		} catch (Exception e) {
			System.out.println("Unable to complete rewardLink redemption for " + userid);
			return null;
		}
	}

}