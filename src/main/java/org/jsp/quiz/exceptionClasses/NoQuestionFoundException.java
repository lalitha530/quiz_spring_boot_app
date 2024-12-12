package org.jsp.quiz.exceptionClasses;

import lombok.Builder;

@Builder
public class NoQuestionFoundException extends RuntimeException
{
	private String message;
	
	public NoQuestionFoundException()
	{
		
	}
	public NoQuestionFoundException(String message)
	{
		this.message=message;
	}
	@Override
	public String getMessage()
	{
		return this.message;
		
	}
}
