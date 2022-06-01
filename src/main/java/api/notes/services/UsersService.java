package api.notes.services;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import api.notes.entities.UsersEntiry;
import api.notes.repositories.UsersRepository;
import api.notes.request.user.UserPostCustomRequest;

@Service
public class UsersService {

	@Autowired
	private UsersRepository user_repo;

	public UsersEntiry getUserByToken(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        
        return user_repo.findByUserName(principal.getName());
	}
	
	public UsersEntiry add(UserPostCustomRequest input) {
		
		UsersEntiry user = user_repo.findByUserName(input.getUserEmail());

		if (user != null) {
			return null;
		}
		
		String user_password = BCrypt.hashpw(input.getUserPassword(), BCrypt.gensalt());
		
		user = new UsersEntiry();
		user.setUserName(input.getUserEmail());
		user.setUserPassword(user_password);
		
		return user_repo.save(user);
	}	
}
