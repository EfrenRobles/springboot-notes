package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.example.demo.models.Users;
import com.example.demo.models.UsersInterface;

@Configuration
public class UsersRepository implements UsersRepositoryInterface {

	@Autowired
	private UsersInterface user_repo;

	@Override
	public Map<String, Object> getUsers() {
		System.out.println("Inside UsersRepository getUsers.");

		List<Users> result = user_repo.findAll();

		Map<String, Object> response = new HashMap<>();
		response.put("status", "SUCCESS");
		response.put("result", result);

		return response;

	}

	@Override
	public Map<String, Object> getUserById(UUID user_id) {
		Optional<Users> result = user_repo.findById(user_id);

		Map<String, Object> response = new HashMap<>();
		response.put("status", "SUCCESS");
		response.put("result", result);

		return response;
	}

}
