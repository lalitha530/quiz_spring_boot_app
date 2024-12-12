package org.jsp.quiz.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.QuestionDao;
import org.jsp.quiz.entity.Question;
import org.jsp.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDaoImpl implements QuestionDao
{
	@Autowired 
	private QuestionRepository respository;

	@Override
	public Question saveQuestion(Question question)
	{
		return respository.save(question);
	}

	@Override
	public List<Question> findAllQuestions() 
	{
		return respository.findAll();
	}

	@Override
	public Optional<Question> findQuestionByid(int id)
	{
		return respository.findById(id);
	}

	@Override
	public List<Question> findAllActiveQuestions() 
	{
		return respository.findAllActiveQuestions();
	}

	@Override
	public List<Question> takeQuiz() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> findRandomQuestions() {
		return respository.findRandomQuestions(PageRequest.of(0, 5));
	}
	
	//@Override
//	public List<Question> takeQuiz()
//	{
//		return Repository.findRandomQuestions(PageRequest.of(0, 5));
//		
//	}
}