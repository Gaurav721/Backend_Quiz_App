package com.gaurav.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurav.quiz.dao.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

	
}
