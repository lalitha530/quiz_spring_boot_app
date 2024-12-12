package org.jsp.quiz.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.QuestionDao;
import org.jsp.quiz.dto.QuestionDto;
import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.entity.Question;
import org.jsp.quiz.exceptionClasses.InvalidQuestionException;
import org.jsp.quiz.exceptionClasses.NoQuestionFoundException;
import org.jsp.quiz.responseStructure.ResponseStructure;
import org.jsp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService
{
	@Autowired
	private QuestionDao dao;
	@Override
	public ResponseEntity<?> saveQuestion(Question question)
	{
		 question = dao.saveQuestion(question);
		
		 
//		 ResponseStructure<Question> structure = new ResponseStructure<>();
//		 structure.setHttpStatus(HttpStatus.OK.value());
//		 structure.setMessage("question saved successfully");
//		 structure.setBody(question);
//		return new ResponseEntity<>(structure,HttpStatus.OK);
		 
		 return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("Question saved successfully").body(question).build());
	}
	
	@Override
	public ResponseEntity<?> findAllQuestions()
	{
		//List<Question>questions = dao.findAllQuestions();
		List<Question>questions = dao.findAllActiveQuestions();
		
		List<QuestionDto> dtolist = new ArrayList<>();
		
		for(Question q : questions)
		
			dtolist.add(new QuestionDto(q.getTitle(),q.getA(),q.getB(),q.getC(),q.getD()));
			if(dtolist.isEmpty())
			
			 throw NoQuestionFoundException.builder().message("no question found in the database").build();
			 return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("All questions found successfully").body(questions).build());
			
	}
	@Override
	public ResponseEntity<?> findQuestionById(int id)
	{
		Optional<Question> optional = dao.findQuestionByid(id);
		if(optional.isEmpty())
		
			throw InvalidQuestionException.builder().message("Invalid question id").build();
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("Question found successfully").body(optional.get()).build());
		
		
	}
	
	@Override
	public ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses)
	{
		int c=0;
		for(QuizResponse qr : quizResponses)
		{
			Optional<Question> q = dao.findQuestionByid(qr.getId());
		
			if(q.isEmpty())
			{
				throw InvalidQuestionException.builder().message("Invalid ques id unable to ").build();
			}
			
			Question question = q.get();
			if(question.getAns().equalsIgnoreCase(qr.getAns()));
			c++;
		}
	
	
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("Submission successfull").body("Your score :  "+ c ));
	}
	
	@Override
	public ResponseEntity<?> takeQuiz()
	{
		List<Question> randomQuestions=dao.findRandomQuestions();
		return null;
	}
		
	
}
