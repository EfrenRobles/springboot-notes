package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.models.Notes;
import com.example.demo.models.NotesInterface;
import com.example.demo.models.Users;
import com.example.demo.models.UsersInterface;

@Configuration
public class NotesRepository extends BaseReposiroty implements NotesRepositoryInterface {

	@Autowired
	private NotesInterface note_repo;

	@Autowired
	private UsersInterface user_repo;

	@Override
	public HashMap<String, Object> getNotes(UUID user_id) {
		Optional<Users> user = user_repo.findById(user_id);
		
		if (user.isPresent()) {
			return this.returnSuccess(note_repo.findByUsers(user.get()));
		}
		
		return this.returnSuccess(new HashMap<String, Object>());
	}

	@Override
	public HashMap<String, Object> getNoteById(UUID note_id, UUID user_id) {
		Optional<Users> user = user_repo.findById(user_id);
		
		if (user.isPresent()) {
			return this.returnSuccess(note_repo.findByNoteIdAndUsers(note_id, user.get()));
		}
		
		return this.returnSuccess(new HashMap<String, Object>());
	}

	@Override
	public HashMap<String, Object> createNote(HashMap<String, Object> data) {
		
		Optional<Users> user = user_repo.findById((UUID) data.get("user_id"));
		
		if (user.isEmpty()) {
			return this.returnSuccess(new HashMap<String, Object>());
		}
		
		Notes note = new Notes();
		note.setUsers(user.get());
		note.setNoteTitle((String) data.get("note_title"));
		note.setNoteMessage((String) data.get("note_message"));
		
		return this.returnSuccess(note_repo.save(note));

	}

}
