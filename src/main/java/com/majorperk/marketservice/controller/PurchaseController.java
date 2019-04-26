package com.majorperk.marketservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.majorperk.marketservice.model.Cart;
import com.majorperk.marketservice.service.CartService;
import com.majorperk.marketservice.service.PurchaseService;


@RestController
class PurchaseController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private PurchaseService purchaseService;

	// Checkout
	@ResponseBody
	@RequestMapping(value = "/checkout", method = RequestMethod.POST, produces = "application/json")
	Cart checkout(@RequestParam(value = "userId", required = true) Long userId,
				  @RequestParam(value = "cartId", required = true) Long cartId,
				  @RequestBody List<Long> rewardItemIds) {		
		purchaseService.purchaseItems(userId, rewardItemIds);
		return cartService.removeItems(cartId, rewardItemIds);
	}
}