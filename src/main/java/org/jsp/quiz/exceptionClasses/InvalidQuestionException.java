package org.jsp.quiz.exceptionClasses;

import lombok.Builder;

@Builder
public class InvalidQuestionException extends RuntimeException
{
	private String message;
	public InvalidQuestionException()
	{
		
	}
	
	public InvalidQuestionException(String message)
	{
		this.message=message;
	}
	
	@Override
	public String getMessage()
	{
		return this.message;
	}

	
}
