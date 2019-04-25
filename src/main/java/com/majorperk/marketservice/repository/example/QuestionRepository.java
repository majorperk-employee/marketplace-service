package com.majorperk.marketservice.repository.example;

import com.majorperk.marketservice.model.example.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}