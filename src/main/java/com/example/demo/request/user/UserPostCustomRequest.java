package com.example.demo.request.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserPostCustomRequest  {

	@NotBlank 
	@Email
	private String userEmail;
	
	@NotBlank
	@Length(min = 8, max = 64)
	private String userPassword;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
		
	
	
}
