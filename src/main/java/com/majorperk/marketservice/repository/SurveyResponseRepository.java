package com.majorperk.marketservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.majorperk.marketservice.model.SurveyResponse;

@Repository
public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {

	public List<SurveyResponse> findByQuestionId(int questionId);
}