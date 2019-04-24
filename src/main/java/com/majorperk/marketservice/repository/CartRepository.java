package com.majorperk.marketservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.majorperk.marketservice.model.Cart;

@Transactional
public interface CartRepository extends CrudRepository<Cart, Long> {
}