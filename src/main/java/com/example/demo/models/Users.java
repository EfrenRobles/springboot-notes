package com.example.demo.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID user_id;

	@Column(name = "user_name", nullable = false)
	private String user_name;
	
	@Column(name = "user_password", nullable = false)
	private String user_password;

	public UUID getId() {
		user_id = UUID.randomUUID();
		return user_id;
	}

	public void setId(UUID id) {
		this.user_id = id;
	}

	public String getName() {
		return user_name;
	}

	public void setName(String name) {
		this.user_name = name;
	}

	public String getPassword() {
		return user_password;
	}

	public void setPassword(String password) {
		this.user_password = password;
	}

}
