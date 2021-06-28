package com.ust.Service;

import com.ust.Exception.UserAlreadyExistsException;
import com.ust.Exception.UserNotFoundException;
import com.ust.Model.User;

public interface UserService {


	User updateUser(String userId, User user) throws UserNotFoundException;

	boolean deleteUser(String userId) throws UserNotFoundException;

	User getUserById(String userId) throws UserNotFoundException;

}
