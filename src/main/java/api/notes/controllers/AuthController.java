package api.notes.controllers;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.notes.entities.UsersEntiry;
import api.notes.request.login.LoginCustomRequest;
import api.notes.services.UsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@Validated
public class AuthController extends BaseResponse {

	@Autowired
	private UsersService userService;
	
	@PostMapping("login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginCustomRequest request) {
		LinkedHashMap<String, Object> data = new LinkedHashMap<>();
		UsersEntiry user = userService.getUser(request.getUserEmail());
		
		boolean pass = (user == null);
	
		if  (! pass) {
			pass = ! BCrypt.checkpw(request.getUserPassword(), user.getUserPassword());
		}
		
		if (pass) {
			return onFail("Username or Password does not match", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		String token = getJWTToken(user.getUserName());
		
		data.put("access_token", token);
		
		return onSuccess(data, HttpStatus.OK);
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts
			.builder()
			.setId("softtekJWT")
			.setSubject(username)
			.claim(
				"authorities",
				grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())
			)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + 36600000))
			.signWith(
				SignatureAlgorithm.HS512,
				secretKey.getBytes()
			)
			.compact();

		return token;
	}
}