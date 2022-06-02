package api.notes.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.notes.request.login.LoginCustomRequest;
import api.notes.services.AuthService;

@RestController
@Validated
public class AuthController extends BaseResponse {

	@Autowired
	private AuthService authService;
	
	@PostMapping("login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginCustomRequest request) {
		
		Optional<Object> result = Optional.ofNullable(authService.login(request));
		
		return result.map(user -> onSuccess(user, HttpStatus.OK))
			.orElse(ResponseEntity
				.status(HttpStatus.UNPROCESSABLE_ENTITY)
				.body(onError("Username or Password does not match"))
			);
	}

}