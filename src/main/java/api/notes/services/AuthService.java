package api.notes.services;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import api.notes.entities.UsersEntiry;
import api.notes.repositories.UsersRepository;
import api.notes.request.login.LoginCustomRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthService {
	
	@Autowired
	private UsersRepository user_repo;

	
	public Object login(LoginCustomRequest input ) {
		UsersEntiry user = user_repo.findByUserName(input.getUserEmail());
		
		if (user == null || ! BCrypt.checkpw(input.getUserPassword(), user.getUserPassword())) {
			return null;
		}
	
		String token = getJWTToken(user.getUserName());
		
		Map<String, Object> data = new LinkedHashMap<>();
		data.put("access_token", token);
		
		return data;
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
