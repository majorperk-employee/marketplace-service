package com.majorperk.marketservice.controller;

import java.util.List;

import javax.validation.Valid;

import com.majorperk.marketservice.model.Catalog;
import com.majorperk.marketservice.model.reward.Brand;
import com.majorperk.marketservice.model.tango.TangoOrder;
import com.majorperk.marketservice.model.tango.TangoOrderResponse;
import com.majorperk.marketservice.repository.BrandRepository;
import com.majorperk.marketservice.service.TangoRewardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("rewardlink")
@PropertySource("classpath:application.yml")
class RewardLinkController {

	@Autowired
	private TangoRewardService tangoRewardService;

	@Autowired
	private BrandRepository brandRepository;

    @Value("${tangocard.baseUrl}")
    private String baseUrl;

    @Value("${tangocard.username}")
    private String username;

    @Value("${tangocard.password}")
    private String password;

	private static String brandKey = "B077325";
	private static String rewardLinkText = "Reward Link Preferred";

	@GetMapping("/view")
	public @Valid Brand getRewardLinkItem() {
		try {
			Brand brandKeyResponse = brandRepository.findFirstByBrandKey(brandKey);
			if (brandKeyResponse != null && brandKeyResponse.getBrandName().contains(rewardLinkText)) {
				return brandKeyResponse;
			}
			Brand brandNameResponse = brandRepository.findFirstByBrandName(rewardLinkText);
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
			RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication(username, password).build();
			return restTemplate.getForObject(baseUrl + "/catalogs?verbose={verbose}", Catalog.class, verbose).getBrands();
		} catch (Exception e) {
			System.out.println("Unable to access TangoCard catalog :::" + e);
			return null;
		}
	}

	// Checkout
	@ResponseBody
	@RequestMapping(value = "/redeem/{userId}", method = RequestMethod.POST, produces = "application/json")
	TangoOrderResponse redeemRewardLink(@PathVariable Long userId, @RequestBody int amount) {
		try {
			TangoOrder order = tangoRewardService.createTangoOrder(userId, amount);
			
			return tangoRewardService.redeemRewardLink(userId, order);
		} catch (Exception e) {
			System.out.println("Unable to complete rewardLink redemption for " + userId + " " + e);
			return null;
		}
	}

}