package com.example.demo.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthController extends BaseController {

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) {
		HashMap<String, Object> data = new HashMap<>();
		Users user = getUser(username);
		
		boolean pass = (user == null);
	
		if  (! pass) {
			pass = ! BCrypt.checkpw(password, user.getUserPassword());
		}
		
		if (pass) {
			data = new HashMap<>();
			data.put("status", "ERROR");
			data.put("error", "Username or Password does not match");

			return new ResponseEntity<>(data, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		String token = getJWTToken(username);
		
		data = new HashMap<>();
		data.put("status", "SUCCESS");
		data.put("access_token", token);
		
		return new ResponseEntity<>(data, HttpStatus.OK);
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
			.setExpiration(new Date(System.currentTimeMillis() + 600000))
			.signWith(
				SignatureAlgorithm.HS512,
				secretKey.getBytes()
			)
			.compact();

		return token;
	}
}