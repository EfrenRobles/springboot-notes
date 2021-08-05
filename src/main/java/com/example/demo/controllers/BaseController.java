package com.example.demo.controllers;

import java.security.Principal;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.models.Users;
import com.example.demo.models.UsersInterface;

public abstract class BaseController {
	
	@Autowired
	private UsersInterface user_repo;
	
	protected ResponseEntity<?> returnResult(HashMap<String, Object> result, int http_staus) {

		if (!result.get("status").equals("SUCCESS")) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (http_staus == 201) {
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}

		if (http_staus == 203) {
			return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	protected Users getUser(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return user_repo.findByUserName(principal.getName());
	}
	
	protected Users getUser(String request) {
        return user_repo.findByUserName(request);
	}	
}
