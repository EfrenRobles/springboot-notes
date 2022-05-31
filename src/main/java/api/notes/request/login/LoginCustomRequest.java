package api.notes.request.login;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginCustomRequest  {

	@NotBlank 
	@Email
	private String userEmail;
	
	@NotBlank
	@Length(min = 8, max = 64)
	private String userPassword;

}
