package com.ust.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.exception.UserAlreadyExistsException;
import com.ust.exception.UserNotFoundException;
import com.ust.model.User;
import com.ust.service.UserAuthenticationService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
public class UserAuthenticationController {

   

	@Autowired
	UserAuthenticationService service;
	@Autowired
	public UserAuthenticationController(UserAuthenticationService authicationService) {
		this.service = authicationService;
	}


	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
try {
			
			if(!service.saveUser(user)) {
				throw new Exception();
			}
			return new ResponseEntity<String>("Registered", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}

	}
	


	

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		try {
			service.findByUserIdAndPassword(user.getUserId(), user.getUserPassword());
			return new ResponseEntity<String>(getToken(user, user.getUserId(), user.getUserPassword()), HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

	// Generate JWT token
	public String getToken(@RequestBody User user, String userId, String userPassword) throws Exception {
		return Jwts.builder().setId(userId).setSubject(userPassword).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();

	}
	}



