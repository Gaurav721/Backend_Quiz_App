package com.gaurav.quiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.quiz.dao.model.Question;
import com.gaurav.quiz.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("Id/{id}")
	public Optional<Question> getQuestionsById(@PathVariable Integer id) {
		return questionService.getQuestionsById(id);
	}
	
	// whenever we are passing variable in path use Path variable
	@GetMapping("category/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}
	
	@GetMapping("level/{level}")
	public List<Question> getQuestionsByLevel(@PathVariable String level){
		return questionService.getQuestionsByLevel(level);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	@DeleteMapping("Id/{Id}")
	public String deleteQuestion(@PathVariable Integer Id) {
		return questionService.deleteQuestion(Id);
	}
	
	@PutMapping("/")
	public String updateQuestion(@RequestBody Question question) {
		return questionService.updateQuestion(question);
	}
}
