package api.notes.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import api.notes.entities.Notes;
import api.notes.entities.NotesInterface;
import api.notes.entities.Users;
import api.notes.entities.UsersInterface;

@Configuration
public class NotesDto extends BaseDto {

	@Autowired
	private NotesInterface note_repo;

	public HashMap<String, Object> getNotes(Users user) {
		return this.returnSuccess(note_repo.findByUsers(user));
	}

	public HashMap<String, Object> getNoteById(UUID note_id, Users user) {
		return this.returnSuccess(note_repo.findByNoteIdAndUsers(note_id, user));
	}

	public HashMap<String, Object> createNote(HashMap<String, Object> data) {
		Notes note = new Notes();
		note.setUsers((Users) data.get("user"));
		note.setNoteTitle((String) data.get("note_title"));
		note.setNoteMessage((String) data.get("note_message"));
		
		return this.returnSuccess(note_repo.save(note));
	}

	public HashMap<String, Object> updateNote(Notes note) {
		return this.returnSuccess(note_repo.save(note));
	}

	public HashMap<String, Object> deleteNote(Notes note) {
		note_repo.delete(note);
		return this.returnSuccess(null);
	}

}
