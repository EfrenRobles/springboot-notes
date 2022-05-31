package api.notes.usecase.users;

import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import api.notes.dto.UsersDto;
import api.notes.usecase.BaseUseCaseInterface;

@Configuration
public class UsersPostUseCase implements BaseUseCaseInterface {

	@Autowired
	private UsersDto user_repo;
	
	@Override
	public LinkedHashMap<String, Object> run(LinkedHashMap<String, Object> data) {
		
		LinkedHashMap<String, Object> result = user_repo.findByUserName((String) data.get("user_email"));
		
		String object_result = result.get("status").toString();
		
		if (object_result.equals("ERROR")) {
			return user_repo.createUser(data);
		}
		
		result.put("status", "ERROR");
		result.put("result", "The username is already registered");
		
		return result;
	}
	
}
