package com.vaibhavshindetech.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhavshindetech.bindings.User;
import com.vaibhavshindetech.bindings.UserResponse;
import com.vaibhavshindetech.entity.UserEntity;
import com.vaibhavshindetech.service.UserRegistrationService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class UserRegistrationRestController {

	@Autowired
	private UserRegistrationService userRegistrationService;

	@PostMapping(value = "/register")
	public ResponseEntity<UserResponse> registerUser(@RequestBody User user) {
		UserResponse userResponse = userRegistrationService.saveUser(user);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/users/{pageNum}")
	public ResponseEntity<Page<UserEntity>> getAllUser(@PathVariable Integer pageNum) {
		Page<UserEntity> page = userRegistrationService.getAllUser(pageNum);
		return new ResponseEntity<Page<UserEntity>>(page, HttpStatus.OK);
	}

}
