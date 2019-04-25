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
import com.majorperk.marketservice.service.OrderService;


@RestController
class OrderController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;

	// Checkout
	@ResponseBody
	@RequestMapping(value = "/checkout", method = RequestMethod.GET, produces = "application/json")
	Cart checkout(@RequestParam(value = "userId", required = true) Long userId,
				  @RequestParam(value = "cartId", required = true) Long cartId,
				  @RequestBody List<Long> rewardItemIds) {
		
		orderService.orderItems(userId, rewardItemIds);		
		return cartService.removeItems(userId, rewardItemIds);
	}
}