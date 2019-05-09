package com.majorperk.marketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.majorperk.marketservice.model.SandPMetrics;

@Repository
public interface SandPMetricsRepository extends JpaRepository<SandPMetrics, Long> {
}