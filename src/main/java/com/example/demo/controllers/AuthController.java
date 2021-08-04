package com.example.demo.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthController {

	@PostMapping("login")
	public HashMap<String, Object> login(@RequestParam("username") String username, @RequestParam("password") String pwd) {

		HashMap<String, Object> data = new HashMap<>();
		data.put("access_token", getJWTToken(username));
		
		//Todo: check user and password from DB;
		
		return data;
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
			.claim("authorities",
				grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + 600000))
			.signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
			.compact();

		return token;
	}
}