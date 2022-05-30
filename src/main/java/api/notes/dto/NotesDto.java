package api.notes.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import api.notes.entities.NotesEntity;
import api.notes.entities.UsersEntiry;
import api.notes.repositories.NotesRepository;
import api.notes.repositories.UsersRepository;

@Configuration
public class NotesDto extends BaseDto {

	@Autowired
	private NotesRepository note_repo;

	public HashMap<String, Object> getNotes(UsersEntiry user) {
		return this.returnSuccess(note_repo.findByUsers(user));
	}

	public HashMap<String, Object> getNoteById(UUID note_id, UsersEntiry user) {
		return this.returnSuccess(note_repo.findByNoteIdAndUsers(note_id, user));
	}

	public HashMap<String, Object> createNote(HashMap<String, Object> data) {
		NotesEntity note = new NotesEntity();
		note.setUsers((UsersEntiry) data.get("user"));
		note.setNoteTitle((String) data.get("note_title"));
		note.setNoteMessage((String) data.get("note_message"));
		
		return this.returnSuccess(note_repo.save(note));
	}

	public HashMap<String, Object> updateNote(NotesEntity note) {
		return this.returnSuccess(note_repo.save(note));
	}

	public HashMap<String, Object> deleteNote(NotesEntity note) {
		note_repo.delete(note);
		return this.returnSuccess(null);
	}

}
