package com.example.demo.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.login.LoginCustomRequest;
import com.example.demo.usecase.users.UsersPostUseCase;

@RestController
@RequestMapping("users")
public class UsersController extends BaseController{

	@Autowired
	private UsersPostUseCase users_post_usecase;

	public UsersController(UsersPostUseCase users_post_usecase) {
		this.users_post_usecase = users_post_usecase;
	}

	@GetMapping
	public ResponseEntity<?> getUser(
			@RequestParam(required = false) Object temp,
			HttpServletRequest request
	) {
		return new ResponseEntity<>(getUser(request), HttpStatus.OK);
	}

	 @PostMapping
	 public ResponseEntity<?> postUser(@Valid @RequestBody LoginCustomRequest request) {
		HashMap<String, Object> data = new HashMap<>();
		data.put("user_email", request.getUserEmail());
		data.put("user_password", request.getUserPassword());
		 
		return this.returnResult(users_post_usecase.run(data), HttpStatus.ACCEPTED);
	 }
	 
}
