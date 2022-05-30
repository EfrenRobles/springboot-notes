package api.notes.dto;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;

import api.notes.entities.Users;
import api.notes.entities.UsersInterface;

@Configuration
public class UsersDto extends BaseDto {

	@Autowired
	private UsersInterface user_repo;

    public HashMap<String, Object> findByUserName(String user_name) {
		HashMap<String, Object> response = new HashMap<>();
    	Users user = user_repo.findByUserName(user_name);
    	
    	if (user == null) {
			response.put("status", "ERROR");
			response.put("result", "User does not exist");
			
			return response;
    	}

    	response.put("status", "SUCCESS");
		response.put("result", user);
    	
        return returnSuccess(response);
    }
	
	public HashMap<String, Object> createUser(HashMap<String, Object> data) {
		
		String user_password = BCrypt.hashpw((String) data.get("user_password"), BCrypt.gensalt());

		Users user = new Users();
		user.setUserName((String) data.get("user_email"));
		user.setUserPassword(user_password);
		
		return returnSuccess(user_repo.save(user));

	}
}
