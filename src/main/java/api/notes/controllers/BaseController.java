package api.notes.controllers;

import java.security.Principal;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import api.notes.entities.Users;
import api.notes.entities.UsersInterface;

public abstract class BaseController {
	
	@Autowired
	private UsersInterface user_repo;
	
	protected ResponseEntity<?> returnResult(HashMap<String, Object> result, HttpStatus accepted) {

		if (!result.get("status").equals("SUCCESS")) {
			return new ResponseEntity<>(result, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>(result, accepted);
	}
	
	protected Users getUser(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return user_repo.findByUserName(principal.getName());
	}
	
	protected Users getUser(String request) {
        return user_repo.findByUserName(request);
	}	
}
