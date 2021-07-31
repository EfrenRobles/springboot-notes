package com.example.demo.models;

import java.util.UUID;

public class Users {

	private UUID id;
	private String name;
	private String password;

	public UUID getId() {
		this.id = UUID.fromString("cf9d1f19-ce69-4ff5-8da1-d3a9ccdbf7b2");
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
