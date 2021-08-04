package com.example.demo.models;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID user_id;

	@Column(name = "user_email", nullable = false)
	private String user_email;

	@Column(name = "user_password", nullable = false)
	private String user_password;

	@CreationTimestamp
	private Timestamp created_at;

	@UpdateTimestamp
	private Timestamp updated_at;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	private Set<Notes> notes;

	private String token;

	public UUID getUserId() {
		return user_id;
	}

	public void setUserId(UUID user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return user_email;
	}

	public void setUserName(String user_name) {
		this.user_email = user_name;
	}

	public String getUserPassword() {
		return user_password;
	}

	public void setUserPassword(String user_password) {
		this.user_password = user_password;
	}

	public Set<Notes> getNotes() {
		return notes;
	}

	public void setNotes(Set<Notes> notes) {
		this.notes = notes;
	}

	public Timestamp getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public String getUserToken() {
		return token;
	}

	public void setUserToken(String token) {
		this.token = token;
	}

}
