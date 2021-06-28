package com.ust.Service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Exception.UserNotFoundException;

import com.ust.Model.User;
import com.ust.Repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository reposit;
	@Override
	public User updateUser(String userId, User user) throws UserNotFoundException {
		try {
			reposit.save(user);
			return reposit.findById(userId).get();
		} catch (NoSuchElementException e) {
			throw new UserNotFoundException("Oops! User not found");
		}
	}

	@Override
	public boolean deleteUser(String userId) throws UserNotFoundException {
		boolean status = false;
		try {
			User userfound = reposit.findById(userId).get();
			if (userfound != null) 
			{
				reposit.delete(userfound);
				status = true;
			}
		} catch (NoSuchElementException exception) {
			throw new UserNotFoundException("User with ID: "+userId+",not found!");
		}
		return status;
	}

	@Override
	public User getUserById(String userId) throws UserNotFoundException {
		try {
			return reposit.findById(userId).get();
		} catch (NoSuchElementException e) {
			throw new UserNotFoundException("User with ID:"+userId+",not found!");
		}
	}
	}


