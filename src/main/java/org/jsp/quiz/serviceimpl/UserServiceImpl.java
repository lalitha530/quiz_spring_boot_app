package org.jsp.quiz.serviceimpl;

import org.jsp.quiz.dao.UserDao;
import org.jsp.quiz.entity.User;
import org.jsp.quiz.responseStructure.ResponseStructure;
import org.jsp.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao dao;

	@Override
	public ResponseEntity<?> saveUser(User user)
	{
		user = dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("user saved successfully").body(user).build());
		
	}

}
