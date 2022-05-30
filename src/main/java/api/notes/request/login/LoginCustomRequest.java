package api.notes.request.login;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class LoginCustomRequest  {

	@NotBlank 
	@Email
	private String userEmail;
	
	@NotBlank
	@Length(min = 8, max = 64)
	private String userPassword;

	public String getEmail() {
		return userEmail;
	}

	public void setEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return userPassword;
	}

	public void setPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
