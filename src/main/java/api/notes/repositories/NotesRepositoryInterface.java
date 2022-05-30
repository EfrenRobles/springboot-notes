package api.notes.repositories;

import java.util.HashMap;
import java.util.UUID;

import api.notes.models.Notes;
import api.notes.models.Users;

public interface NotesRepositoryInterface {
	public HashMap<?, ?> getNotes(Users user);

	public HashMap<?, ?> getNoteById(UUID note_id, Users user);
	
	public HashMap<?, ?> createNote(HashMap<String, Object> data);

	public HashMap<?, ?> updateNote(Notes note);

	public HashMap<?, ?> deleteNote(Notes note);
}


