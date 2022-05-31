package api.notes.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.notes.entities.NotesEntity;
import api.notes.entities.UsersEntiry;
import api.notes.repositories.NotesRepository;
import api.notes.request.notes.NotesPatchCustomRequest;
import api.notes.request.notes.NotesPostCustomRequest;

@Service
public class NotesService {

	@Autowired
	private NotesRepository note_repo;

	public List<NotesEntity> getNotesFromUser(UsersEntiry user) {
		return  note_repo.findByUsers(user);
	}
	
	public NotesEntity getNotesFromUserWithId(UUID note_id, UsersEntiry user) {
		return note_repo.findByNoteIdAndUsers(note_id, user);
	}
	
	public NotesEntity add(NotesPostCustomRequest input, UsersEntiry user) {
		NotesEntity note = new NotesEntity();
		note.setUsers(user);		
		note.setNoteTitle(input.getTitle());
		note.setNoteMessage(input.getNote());
		
		return note_repo.save(note);
	}

	public NotesEntity update(UUID id, NotesPatchCustomRequest input, UsersEntiry user) {
		
		NotesEntity note = note_repo.findByNoteIdAndUsers(id, user);
		
		if (note == null) {
			return null;
		}

		note.setNoteTitle(input.getTitle());
		note.setNoteMessage(input.getNote());

		return note_repo.save(note);
	}	
	
	public Boolean deleteByIdWithUser(UUID id, UsersEntiry user) {
		
		NotesEntity note = note_repo.findByNoteIdAndUsers(id, user);
		
		if (note == null) {
			return false;
		}

		note_repo.delete(note);

		return (getNotesFromUserWithId(id, user) == null);
	}
}
