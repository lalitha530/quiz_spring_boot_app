package org.jsp.quiz.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.entity.Question;

public interface QuestionDao 
{

	Question saveQuestion(Question question);

	List<Question> findAllQuestions();

	Optional<Question> findQuestionByid(int id);

	List<Question> findAllActiveQuestions();

	List<Question> takeQuiz();

	List<Question> findRandomQuestions();

	
}
