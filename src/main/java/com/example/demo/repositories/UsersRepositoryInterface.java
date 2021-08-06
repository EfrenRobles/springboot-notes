package com.example.demo.repositories;

import java.util.HashMap;
import java.util.UUID;

import com.example.demo.models.Users;

public interface UsersRepositoryInterface {

    public HashMap<String, Object> findByUserName(String user_name);
    
	public HashMap<?, ?> createUser(HashMap<String, Object> data);
}


