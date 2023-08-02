package com.gaurav.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gaurav.quiz.dao.QuestionDao;
import com.gaurav.quiz.dao.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	public Optional<Question> getQuestionsById(Integer Id) {
		return questionDao.findById(Id);
	}
	
	public List<Question> getQuestionsByCategory(String category) {
		
		return questionDao.findByCategory(category);
	}
	
	public List<Question> getQuestionsByLevel(String level){
		return questionDao.findByLevel(level);
	}


	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public String deleteQuestion(Integer id) {
		questionDao.deleteById(id);
		return "Success";
	}

	public String updateQuestion(Question question) {
		questionDao.save(question);
		return "Updated";
	}

}
