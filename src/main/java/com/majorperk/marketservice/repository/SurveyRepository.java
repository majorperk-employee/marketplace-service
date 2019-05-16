package com.majorperk.marketservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.majorperk.marketservice.model.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

	List<Survey> findByPeriod(int period);
}