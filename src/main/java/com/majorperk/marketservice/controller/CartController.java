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
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	Cart addItem(@RequestParam(value = "cartId", required = true) Long cartId,
			@RequestParam(value = "itemId", required = true) Long itemId) {
		return cartService.addItem(cartId, itemId);
	}
	
	// POST remove items from the cart
	@ResponseBody
	@RequestMapping(value = "/removeMultiple", method = RequestMethod.POST, produces = "application/json")
	Cart removeItems(@RequestParam(value = "cartId", required = true) Long cartId, @RequestBody List<Long> rewardItemIds) {
		return cartService.removeItems(cartId, rewardItemIds);
	}

	// GET remove item from Cart
	@ResponseBody
	@RequestMapping(value = "/remove", method = RequestMethod.GET, produces = "application/json")
	Cart removeItem(@RequestParam(value = "cartId", required = true) Long cartId,
			@RequestParam(value = "itemId", required = true) Long itemToDrop) {
		return cartService.removeItem(cartId, itemToDrop);
	}

	// GET Cart
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	Cart cartContents(@PathVariable Long id) {
		return cartService.getCart(id);
	}
}