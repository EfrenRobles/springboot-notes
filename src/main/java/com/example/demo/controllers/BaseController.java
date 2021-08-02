package com.example.demo.controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
	
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
}
