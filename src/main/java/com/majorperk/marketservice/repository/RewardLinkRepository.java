package com.majorperk.marketservice.repository;

import com.majorperk.marketservice.model.tango.TangoOrderResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardLinkRepository extends JpaRepository<TangoOrderResponse, Long> {
}