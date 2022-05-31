package api.notes.services;

import java.util.LinkedHashMap;
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
public class NotesService extends BaseService {

	@Autowired
	private NotesRepository note_repo;

	public LinkedHashMap<String, Object> getNotes(UsersEntiry user) {
		return this.returnSuccess(note_repo.findByUsers(user));
	}

	public LinkedHashMap<String, Object> getNoteById(UUID note_id, UsersEntiry user) {
		return this.returnSuccess(note_repo.findByNoteIdAndUsers(note_id, user));
	}

	public LinkedHashMap<String, Object> createNote(LinkedHashMap<String, Object> data) {
		NotesEntity note = new NotesEntity();
		note.setUsers((UsersEntiry) data.get("user"));
		note.setNoteTitle((String) data.get("note_title"));
		note.setNoteMessage((String) data.get("note_message"));
		
		return this.returnSuccess(note_repo.save(note));
	}

	public LinkedHashMap<String, Object> updateNote(NotesEntity note) {
		return this.returnSuccess(note_repo.save(note));
	}

	public LinkedHashMap<String, Object> deleteNote(NotesEntity note) {
		note_repo.delete(note);
		return this.returnSuccess(null);
	}

}
