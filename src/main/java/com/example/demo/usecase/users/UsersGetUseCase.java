package com.example.demo.usecase.users;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repositories.UsersRepository;
import com.example.demo.usecase.BaseUseCaseInterface;

@Configuration
public class UsersGetUseCase implements BaseUseCaseInterface {

	@Autowired
	private UsersRepository user_repo;
	
	public UsersGetUseCase(UsersRepository user_repo) {
		this.user_repo = user_repo;
	}
	
	@Override
	public HashMap<String, Object> run(HashMap<String, Object> data) {
		if (data.get("user_id") == null) {
			return user_repo.getUsers();
		}
		
		return user_repo.getUserById((UUID) data.get("user_id"));
	}
}
