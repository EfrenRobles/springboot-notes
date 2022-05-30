package api.notes.repositories;

import java.util.HashMap;
import java.util.UUID;

import api.notes.models.Users;

public interface UsersRepositoryInterface {

    public HashMap<String, Object> findByUserName(String user_name);
    
	public HashMap<?, ?> createUser(HashMap<String, Object> data);
}


