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

public abstract class BaseController {
	
	@Autowired
	private UsersRepository user_repo;
	
	private final String SUCCESS = "SUCCESS";
	private final String ERROR = "ERROR";
	private final String FAIL = "FAIL";
	

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
	
	protected ResponseEntity<?> onSuccess (LinkedHashMap<String, Object> result, HttpStatus accepted) {
		return seResponse(result, SUCCESS, accepted);
	}
	
	protected ResponseEntity<?> onFail (LinkedHashMap<String, Object> result, HttpStatus accepted) {
		return seResponse(result, ERROR, accepted);
	}
	
	protected ResponseEntity<?> onError (LinkedHashMap<String, Object> result, HttpStatus accepted) {
		return seResponse(result, FAIL, accepted);
	}
	
	private ResponseEntity<?> seResponse (Object result, String status, HttpStatus accepted) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", status);
		response.put("data", result);

		return ResponseEntity.ok(response);		
	}
}
