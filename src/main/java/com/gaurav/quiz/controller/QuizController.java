package com.gaurav.quiz.controller;

import java.util.List;

import com.gaurav.quiz.dao.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gaurav.quiz.dao.model.Question;
import com.gaurav.quiz.dao.model.QuestionWrapper;
import com.gaurav.quiz.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam Integer numQ,@RequestParam String title){
		return quizService.createQuiz(category,numQ,title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
		return quizService.getQuizQuestion(id);
	}

	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id , @RequestBody List<Response> responses){

		return quizService.calculateResult(id , responses);
	}
}
