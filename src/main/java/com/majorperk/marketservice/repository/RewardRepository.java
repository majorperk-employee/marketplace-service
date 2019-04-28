package com.majorperk.marketservice.repository;

import java.util.List;

import com.majorperk.marketservice.model.reward.RewardItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<RewardItem, Long> {
    public List<RewardItem> findAllByUtid(List<String> utId);
    public RewardItem findByUtid(String utId);
}