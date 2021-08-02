package com.example.demo.repositories;

import java.util.HashMap;
import java.util.UUID;

public interface UsersRepositoryInterface {
	public HashMap<?, ?> getUsers();

	public HashMap<?, ?> getUserById(UUID user_id);
	
	public HashMap<?, ?> createUser(HashMap<String, Object> data);
}


