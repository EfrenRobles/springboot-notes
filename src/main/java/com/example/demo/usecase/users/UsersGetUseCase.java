package com.example.demo.usecase.users;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repositories.UsersRepository;

@Configuration
public class UsersGetUseCase {

	@Autowired
	private UsersRepository user_repo;
	
	public UsersGetUseCase(UsersRepository user_repo) {
		this.user_repo = user_repo;
	}
	
	public Map<String, Object> run(Object data) {
		return user_repo.getUsers();
	}
}
