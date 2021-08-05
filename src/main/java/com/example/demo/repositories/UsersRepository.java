package com.example.demo.repositories;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.example.demo.models.Users;
import com.example.demo.models.UsersInterface;

@Configuration
public class UsersRepository extends BaseReposiroty implements UsersRepositoryInterface {

	@Autowired
	private UsersInterface user_repo;

	@Override
	public HashMap<String, Object> createUser(HashMap<String, Object> data) {
		
		String user_password = BCrypt.hashpw((String) data.get("user_password"), BCrypt.gensalt());

		Users user = new Users();
		user.setUserName((String) data.get("user_email"));
		user.setUserPassword(user_password);
		
		return this.returnSuccess(user_repo.save(user));

	}
}
