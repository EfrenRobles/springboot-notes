package com.example.demo.repositories;

import java.util.Map;
import java.util.UUID;

public interface UsersRepositoryInterface {
	public Map<String, Object> getUsers();

	public Map<String, Object> getUserById(UUID user_id);
}
