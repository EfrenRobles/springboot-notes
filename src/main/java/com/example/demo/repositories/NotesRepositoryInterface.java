package com.example.demo.repositories;

import java.util.HashMap;
import java.util.UUID;

import com.example.demo.models.Users;

public interface NotesRepositoryInterface {
	public HashMap<?, ?> getNotes(Users user);

	public HashMap<?, ?> getNoteById(UUID note_id, Users user);
	
	public HashMap<?, ?> createNote(HashMap<String, Object> data);
}


