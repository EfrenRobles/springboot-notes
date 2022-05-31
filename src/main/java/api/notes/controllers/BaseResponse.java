package api.notes.controllers;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import api.notes.entities.UsersEntiry;
import api.notes.repositories.UsersRepository;

public abstract class BaseResponse {
	
	private final String SUCCESS = "SUCCESS";
	private final String ERROR = "ERROR";
	private final String FAIL = "FAIL";
	
	protected ResponseEntity<?> onSuccess (Object result, HttpStatus status) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", SUCCESS);
		response.put("data", result);

		return new ResponseEntity<>(response, status);
	}
	
	protected ResponseEntity<?> onFail (String result, HttpStatus status) {
		return new ResponseEntity<>(setResponse(result, FAIL), status);
	}
	
	protected ResponseEntity<?> onError (String result, HttpStatus status) {
		return new ResponseEntity<>(setResponse(result, ERROR), status);
	}
	
	private Map setResponse (String result, String status) {
		Map<String, String> response = new LinkedHashMap<>();
		response.put("status", status);
		response.put("error", result);

		return response;		
	}
}
