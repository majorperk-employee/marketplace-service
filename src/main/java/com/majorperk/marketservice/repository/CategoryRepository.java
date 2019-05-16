package com.majorperk.marketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.majorperk.marketservice.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}