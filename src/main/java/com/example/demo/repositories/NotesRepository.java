package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
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

	@Override
	public HashMap<String, Object> getNotes(Users user) {
		return this.returnSuccess(note_repo.findByUsers(user));
	}

	@Override
	public HashMap<String, Object> getNoteById(UUID note_id, Users user) {
		return this.returnSuccess(note_repo.findByNoteIdAndUsers(note_id, user));
	}

	@Override
	public HashMap<String, Object> createNote(HashMap<String, Object> data) {
		Notes note = new Notes();
		note.setUsers((Users) data.get("user"));
		note.setNoteTitle((String) data.get("note_title"));
		note.setNoteMessage((String) data.get("note_message"));
		
		return this.returnSuccess(note_repo.save(note));

	}

}
