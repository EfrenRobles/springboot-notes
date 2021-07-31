package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Users;

@RestController
@RequestMapping("users")
public class UsersController {

	@GetMapping
	public ResponseEntity<Users> getUser() {
		Users user = new Users();
		user.setName("Efren");
		user.setPassword("0123456");

		return ResponseEntity.ok(user);
	}
}
