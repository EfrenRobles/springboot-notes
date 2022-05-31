package api.notes.controllers;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.notes.entities.UsersEntiry;
import api.notes.request.login.LoginCustomRequest;
import api.notes.request.user.UserPostCustomRequest;
import api.notes.usecase.users.UsersPostUseCase;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController extends BaseResponse {

	@Autowired
	private UsersPostUseCase users_post_usecase;

	@GetMapping
	public ResponseEntity<?> getUser(HttpServletRequest request) {
		return onSuccess(getUser(request), HttpStatus.OK);
	}

	 @PostMapping
	 public ResponseEntity<?> postUser(@Valid @RequestBody UserPostCustomRequest input) {
		LinkedHashMap<String, Object> data = new LinkedHashMap<>();
		data.put("user_email", input.getEmail());
		data.put("user_password", input.getPassword());
		 
		return returnResult(users_post_usecase.run(data), HttpStatus.ACCEPTED);
	 }
}
