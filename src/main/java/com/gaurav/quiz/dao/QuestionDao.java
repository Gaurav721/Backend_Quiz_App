package com.gaurav.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gaurav.quiz.dao.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

	List<Question> findByCategory(String category);
	
	List<Question> findByLevel(String level);

	@Query(value="Select * from question q where q.category=:category order by random() limit :numQ",nativeQuery= true)
	List<Question> findRandomQuestionsByCategory(String category, Integer numQ);
}
