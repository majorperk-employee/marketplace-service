package com.majorperk.marketservice.controller;

import java.util.List;

import com.majorperk.marketservice.model.Cart;
import com.majorperk.marketservice.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("cart")
class CartController {

	@Autowired
	private CartService cartService;

	// POST add item to cart
	@ResponseBody
	@RequestMapping(value = "/{id}/add", method = RequestMethod.POST, produces = "application/json")
	Cart addItem(@PathVariable Long id, @RequestBody Long itemId) {
		try {
			return cartService.addItem(id, itemId);
		} catch (Exception e) {
			System.out.println("Unable to add items for user: " + id);
			return new Cart();
		}
	}
	
	// POST remove items from the cart
	@ResponseBody
	@RequestMapping(value = "/{id}/remove", method = RequestMethod.POST, produces = "application/json")
	Cart removeItems(@PathVariable Long id, @RequestBody List<Long> itemIds) {
		try {
			return cartService.removeItems(id, itemIds);
		} catch (Exception e) {
			System.out.println("Unable to remove items for user: " + id);
			return new Cart();
		}
	}

	// GET Cart
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	Cart cartContents(@PathVariable Long id) {
		try {
			return cartService.getCart(id);
		} catch (Exception e) {
			System.out.println("Unable to get cart " + id);
			return new Cart();
		}
	}
}