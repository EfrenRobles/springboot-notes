package api.notes.services;

import java.security.Principal;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import api.notes.entities.UsersEntiry;
import api.notes.repositories.UsersRepository;

@Service
public class UsersService extends BaseService {

	@Autowired
	private UsersRepository user_repo;

	public UsersEntiry getUserByToken(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        
        return user_repo.findByUserName(principal.getName());
	}
	
	public UsersEntiry getUser(String request) {
        return user_repo.findByUserName(request);
	}	

	public ResponseEntity<?> returnResult(LinkedHashMap<String, Object> result, HttpStatus accepted) {

		if (!result.get("status").equals("SUCCESS")) {
			return new ResponseEntity<>(result, HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>(result, accepted);
	}
	
    public LinkedHashMap<String, Object> findByUserName(String user_name) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<>();
    	UsersEntiry user = user_repo.findByUserName(user_name);
    	
    	if (user == null) {
			response.put("status", "ERROR");
			response.put("result", "User does not exist");
			
			return response;
    	}

    	response.put("status", "SUCCESS");
		response.put("result", user);
    	
        return returnSuccess(response);
    }
	
	public LinkedHashMap<String, Object> createUser(LinkedHashMap<String, Object> data) {
		
		String user_password = BCrypt.hashpw((String) data.get("user_password"), BCrypt.gensalt());

		UsersEntiry user = new UsersEntiry();
		user.setUserName((String) data.get("user_email"));
		user.setUserPassword(user_password);
		
		return returnSuccess(user_repo.save(user));

	}
	
	public LinkedHashMap<String, Object> usersPostUseCase(LinkedHashMap<String, Object> data) {
		
		LinkedHashMap<String, Object> result = findByUserName((String) data.get("user_email"));
		
		String object_result = result.get("status").toString();
		
		if (object_result.equals("ERROR")) {
			return createUser(data);
		}
		
		result.put("status", "ERROR");
		result.put("result", "The username is already registered");
		
		return result;
	}	
}
