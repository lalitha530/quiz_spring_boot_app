package org.jsp.quiz.repository;

import org.jsp.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> 
{
	
}
