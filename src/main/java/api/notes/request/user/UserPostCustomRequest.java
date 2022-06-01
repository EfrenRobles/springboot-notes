package api.notes.request.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserPostCustomRequest {
	@NotBlank 
	@Email
	private String userEmail;
	
	@NotBlank
	@Length(min = 8, max = 64)
	private String userPassword;
}
