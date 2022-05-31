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
	
	// --------------------------------------------------------------------------------------------

	@Autowired
	private UsersRepository user_repo;
	
	protected UsersEntiry getUser(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return user_repo.findByUserName(principal.getName());
	}
	
	protected UsersEntiry getUser(String request) {
        return user_repo.findByUserName(request);
	}	

	protected ResponseEntity<?> returnResult(LinkedHashMap<String, Object> result, HttpStatus accepted) {

		if (!result.get("status").equals("SUCCESS")) {
			return new ResponseEntity<>(result, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>(result, accepted);
	}
	
	// --------------------------------------------------------------------------------------------
	
	private final String SUCCESS = "SUCCESS";
	private final String ERROR = "ERROR";
	private final String FAIL = "FAIL";
	
	protected ResponseEntity<?> onSuccess (Object result, HttpStatus status) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", SUCCESS);
		response.put("data", result);

		return new ResponseEntity<>(response, status);
	}
	
	protected ResponseEntity<?> onFail (Object result, HttpStatus status) {
		return new ResponseEntity<>(setResponse(result, FAIL), status);
	}
	
	protected ResponseEntity<?> onError (Object result, HttpStatus status) {
		return new ResponseEntity<>(setResponse(result, ERROR), status);
	}
	
	private Map setResponse (Object result, String status) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", status);
		response.put("error", result);

		return response;		
	}
}
