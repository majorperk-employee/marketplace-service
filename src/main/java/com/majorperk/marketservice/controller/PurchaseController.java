package com.majorperk.marketservice.controller;

import java.util.List;

import com.majorperk.marketservice.model.Cart;
import com.majorperk.marketservice.service.CartService;
import com.majorperk.marketservice.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
class PurchaseController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private PurchaseService purchaseService;

	// Checkout
	@ResponseBody
	@RequestMapping(value = "/checkout", method = RequestMethod.POST, produces = "application/json")
	Cart checkout(@RequestParam(value = "userId", required = true) Long userId) {		
		List<Long> purchasedItems = purchaseService.purchaseItems(userId);
		if (purchasedItems.size() > 0 ) {
			return cartService.removeItems(userId, purchasedItems);
		} else {
			return cartService.getCartByUser(userId);
		}
	}
}