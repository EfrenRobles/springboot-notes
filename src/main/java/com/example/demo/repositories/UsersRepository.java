package com.example.demo.repositories;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.example.demo.models.Users;
import com.example.demo.models.UsersInterface;

@Configuration
public class UsersRepository extends BaseReposiroty implements UsersRepositoryInterface {

	@Autowired
	private UsersInterface user_repo;

	@Override
	public HashMap<String, Object> getUsers() {
		return this.returnSuccess(user_repo.findAll());
	}

	@Override
	public HashMap<String, Object> getUserById(UUID user_id) {
		return this.returnSuccess(user_repo.findById(user_id));
	}

	@Override
	public HashMap<String, Object> createUser(HashMap<String, Object> data) {
		Users user = new Users();
		user.setUserName((String) data.get("user_email"));
		user.setUserPassword((String) data.get("user_password"));
		
		return this.returnSuccess(user_repo.save(user));

	}

}
