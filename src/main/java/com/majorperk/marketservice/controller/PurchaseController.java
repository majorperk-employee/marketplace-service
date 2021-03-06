package com.majorperk.marketservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.majorperk.marketservice.model.Cart;
import com.majorperk.marketservice.model.Purchase;
import com.majorperk.marketservice.service.CartService;
import com.majorperk.marketservice.service.PurchaseService;

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
	@RequestMapping(value = "/checkout/{id}", method = RequestMethod.POST, produces = "application/json")
	Cart checkout(@PathVariable Long id) {
		try {
			List<Long> purchasedItems = purchaseService.purchaseItems(id);
			if (purchasedItems.size() > 0) {
				return cartService.removeItems(id, purchasedItems);
			} else {
				return cartService.getCartByUser(id);
			}	
		} catch (Exception e) {
			System.out.println("Unable to complete purchase for " + id);
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