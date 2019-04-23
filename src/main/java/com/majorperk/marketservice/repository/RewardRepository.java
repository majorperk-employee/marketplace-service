package com.majorperk.marketservice.repository;

import com.majorperk.marketservice.model.RewardItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<RewardItem, Long> {
}