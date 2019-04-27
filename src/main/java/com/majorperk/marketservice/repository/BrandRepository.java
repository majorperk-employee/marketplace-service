package com.majorperk.marketservice.repository;

import com.majorperk.marketservice.model.reward.Brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {}