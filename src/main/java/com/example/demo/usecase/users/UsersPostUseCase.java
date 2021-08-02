package com.example.demo.usecase.users;

import java.util.HashMap;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repositories.UsersRepository;
import com.example.demo.usecase.BaseUseCaseInterface;

@Configuration
public class UsersPostUseCase implements BaseUseCaseInterface {

	private UsersRepository user_repo;

	public UsersPostUseCase(UsersRepository user_repo) {
		this.user_repo = user_repo;
	}
	
	@Override
	public HashMap<String, Object> run(HashMap<String, Object> data) {
		return user_repo.createUser(data);
	}
	
}
