package org.jsp.quiz.Controller;

import org.jsp.quiz.entity.User;
import org.jsp.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService service;
	
	
	@PostMapping("/users")
	public ResponseEntity<?> Saveuser(@RequestBody User user)
	{
		return service.saveUser(user);
		
	}
}
