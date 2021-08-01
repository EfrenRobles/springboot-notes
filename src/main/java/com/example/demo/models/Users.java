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

	/**
	 * @return the user_id
	 */
	public UUID getUserId() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUserId(UUID user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the user_name
	 */
	public String getUserName() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the user_password
	 */
	public String getUserPassword() {
		return user_password;
	}

	/**
	 * @param user_password the user_password to set
	 */
	public void setUserPassword(String user_password) {
		this.user_password = user_password;
	}

}
