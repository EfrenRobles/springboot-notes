package api.notes.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.notes.request.user.UserPostCustomRequest;
import api.notes.services.UsersService;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController extends BaseResponse {

	@Autowired
	private UsersService userService;
	
	@GetMapping
	public ResponseEntity<?> getUser(HttpServletRequest request) {
		return onSuccess(userService.getUserByToken(request), HttpStatus.OK);
	}

	 @PostMapping
	 public ResponseEntity<?> postUser(@Valid @RequestBody UserPostCustomRequest input) {

		Object result = userService.add(input);
		 
		if (result == null) {
			return onSuccess("The username is already registered", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		 
		return onSuccess(result, HttpStatus.ACCEPTED);
	 }
}
