package com.majorperk.marketservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.majorperk.marketservice.model.Cart;
import com.majorperk.marketservice.model.RewardItem;
import com.majorperk.marketservice.service.CartService;


@RestController
class CartController {

	@Autowired
	private CartService cartService;

	// POST add item to cart
	@ResponseBody
	@RequestMapping(value = "/cart/add", method = RequestMethod.POST, produces = "application/json")
	Cart addItem(@RequestParam(value = "cartId", required = true) Long cartId,
			@RequestParam(value = "itemId", required = true) Long itemId) {
		return cartService.addItem(cartId, itemId);
	}
	
	// POST remove items from the cart
	@ResponseBody
	@RequestMapping(value = "/cart/removeMultiple", method = RequestMethod.POST, produces = "application/json")
	Cart removeItems(@RequestParam(value = "cartId", required = true) Long cartId, @RequestBody List<Long> rewardItemIds) {
		return cartService.removeItems(cartId, rewardItemIds);
	}

	// GET remove item from Cart
	@ResponseBody
	@RequestMapping(value = "/cart/remove", method = RequestMethod.GET, produces = "application/json")
	Cart removeItem(@RequestParam(value = "cartId", required = true) Long cartId,
			@RequestParam(value = "itemId", required = true) Long itemToDrop) {
		return cartService.removeItem(cartId, itemToDrop);
	}

	// GET Cart
	@ResponseBody
	@RequestMapping(value = "/cart", method = RequestMethod.GET, produces = "application/json")
	Cart cartContents(@RequestParam(value = "cartId", required = true) Long cartId) {		
		return cartService.getCart(cartId);
	}
}