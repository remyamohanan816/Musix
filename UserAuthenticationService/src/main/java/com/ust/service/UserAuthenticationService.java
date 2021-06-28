package com.ust.service;

import org.springframework.stereotype.Repository;

import com.ust.exception.UserAlreadyExistsException;
import com.ust.exception.UserNotFoundException;
import com.ust.model.User;

@Repository
public interface UserAuthenticationService {
	
	 public User findByUserIdAndPassword(String userId, String userPassword) throws UserNotFoundException;

	 boolean saveUser(User user) throws UserAlreadyExistsException;
}
