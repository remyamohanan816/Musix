package com.ust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.exception.UserAlreadyExistsException;
import com.ust.exception.UserNotFoundException;
import com.ust.model.User;
import com.ust.repository.UserAuthenticationRepository;
@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	@Autowired
	UserAuthenticationRepository repo;
	
	public UserAuthenticationServiceImpl(UserAuthenticationRepository repo) {
		this.repo = repo;
	}
	@Override
	public User findByUserIdAndPassword(String userId, String userPassword) throws UserNotFoundException {
		User user=repo.findByUserIdAndUserPassword(userId, userPassword);
		if(user ==null) {
			throw new UserNotFoundException("User is not found");
		}
		return user;
	}
	

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		if(repo.findById(user.getUserId()).isPresent()){
			throw new UserAlreadyExistsException("User already exist");
		}
		repo.save(user);
		return true;
	}

}
