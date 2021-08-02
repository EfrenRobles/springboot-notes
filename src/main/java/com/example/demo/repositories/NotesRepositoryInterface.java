package com.example.demo.repositories;

import java.util.HashMap;
import java.util.UUID;

public interface NotesRepositoryInterface {
	public HashMap<?, ?> getNotes(UUID user_id);

	public HashMap<?, ?> getNoteById(UUID note_id, UUID user_id);
	
	public HashMap<?, ?> createNote(HashMap<String, Object> data);
}


