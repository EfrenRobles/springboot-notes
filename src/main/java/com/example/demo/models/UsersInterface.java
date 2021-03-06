package com.example.demo.models;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersInterface extends JpaRepository<Users, UUID> {
	public Users findByUserName(String user_name);
}
