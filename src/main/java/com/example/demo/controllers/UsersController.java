package com.example.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Users;
import com.example.demo.usecase.users.UsersGetUseCase;
import com.example.demo.usecase.users.UsersPostUseCase;

@RestController
@RequestMapping("users")
public class UsersController {

	@Autowired
	private UsersGetUseCase users_get_usecase;

	@Autowired
	private UsersPostUseCase users_post_usecase;

	public UsersController(
		UsersGetUseCase users_get_usecase,
		UsersPostUseCase users_post_usecase
		
	) {
		this.users_get_usecase = users_get_usecase;
		this.users_post_usecase = users_post_usecase;
	}	

	@GetMapping
	public ResponseEntity<Map<String, Object>> getUser() {
		Object data = new Object();
		return ResponseEntity.ok(users_get_usecase.run(data));
	}
	
	/*
	@PostMapping
	public ResponseEntity<Map<String, Object>> postUser(@RequestBody Users user, UsersPostUseCase usecase) {
		Users result = usecase.save(user);
		
		Map<String, Object> result = usecase.
		
		return ResponseEntity.ok(result);
	}	
	*/
}
