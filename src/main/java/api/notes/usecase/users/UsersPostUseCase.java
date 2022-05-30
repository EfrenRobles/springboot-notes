package api.notes.usecase.users;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import api.notes.dto.UsersDto;
import api.notes.usecase.BaseUseCaseInterface;

@Configuration
public class UsersPostUseCase implements BaseUseCaseInterface {

	@Autowired
	private UsersDto user_repo;
	
	@Override
	public HashMap<String, Object> run(HashMap<String, Object> data) {
		
		HashMap<String, Object> result = user_repo.findByUserName((String) data.get("user_email"));
		
		String object_result = (String) result.get("status");
		
		if (object_result.equals("ERROR")) {
			return user_repo.createUser(data);
		}
		
		result.put("status", "ERROR");
		result.put("result", "The username is already registered");
		
		return result;
	}
	
}
