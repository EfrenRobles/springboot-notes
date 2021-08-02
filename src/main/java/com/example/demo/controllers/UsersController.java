package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.usecase.users.UsersGetUseCase;
import com.example.demo.usecase.users.UsersPostUseCase;

@RestController
@RequestMapping("users")
public class UsersController extends BaseController{

	@Autowired
	private UsersGetUseCase users_get_usecase;

	@Autowired
	private UsersPostUseCase users_post_usecase;

	public UsersController(UsersGetUseCase users_get_usecase, UsersPostUseCase users_post_usecase) {
		this.users_get_usecase = users_get_usecase;
		this.users_post_usecase = users_post_usecase;
	}

	@GetMapping
	public ResponseEntity<?> getUser(@RequestParam(required = false) UUID user_id) {
		HashMap<String, Object> data = new HashMap<>();
		data.put("user_id", user_id);
		
		return this.returnResult(users_get_usecase.run(data), 200);
	}

	 @PostMapping
	 public ResponseEntity<?> postUser(@RequestBody HashMap<String, Object> request) {
		HashMap<String, Object> data = new HashMap<>();
		data.put("user_name", request.get("user_name"));
		data.put("user_password", request.get("user_password"));
		 
		 return this.returnResult(users_post_usecase.run(data), 201);
	 }
	 
}
