package com.majorperk.marketservice.controller;

import java.util.ArrayList;
import java.util.List;

import com.majorperk.marketservice.model.Cart;
import com.majorperk.marketservice.model.Purchase;
import com.majorperk.marketservice.service.CartService;
import com.majorperk.marketservice.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("purchase")
class PurchaseController {

	@Autowired
	private CartService cartService;

	@Autowired
	private PurchaseService purchaseService;

	// Checkout
	@ResponseBody
	@RequestMapping(value = "/checkout", method = RequestMethod.POST, produces = "application/json")
	Cart checkout(@RequestParam(value = "userId", required = true) Long userId) {
		try {
			List<Long> purchasedItems = purchaseService.purchaseItems(userId);
			if (purchasedItems.size() > 0) {
				return cartService.removeItems(userId, purchasedItems);
			} else {
				return cartService.getCartByUser(userId);
			}	
		} catch (Exception e) {
			System.out.println("Unable to complete purchase for " + userId);
			return new Cart(-1);
		}
	}

	// Get all by ID
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	List<Purchase> getAllPurchases(@PathVariable Long id) {
		try {
			return purchaseService.getPurchases(id);
		} catch (Exception e) {
			System.out.println("Unable to get purchases for " + id);
			return new ArrayList<Purchase>();
		}
	}
}