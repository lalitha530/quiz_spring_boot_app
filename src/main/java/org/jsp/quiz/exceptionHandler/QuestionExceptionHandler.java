package org.jsp.quiz.exceptionHandler;

import org.jsp.quiz.exceptionClasses.NoQuestionFoundException;
import org.jsp.quiz.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionExceptionHandler
{
	@ExceptionHandler(NoQuestionFoundException.class)
	public ResponseEntity<?> noQuestionFoundExceptionHandler(NoQuestionFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("Question not found").body(e).build());
		
	}
}
