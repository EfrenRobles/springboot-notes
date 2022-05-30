package api.notes.usecase.notes;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import api.notes.dto.NotesDto;
import api.notes.entities.Users;
import api.notes.usecase.BaseUseCaseInterface;

@Configuration
public class NotesGetUseCase implements BaseUseCaseInterface {

	@Autowired
	private NotesDto note_repo;

	@Override
	public HashMap<String, Object> run(HashMap<String, Object> data) {
		if (data.get("note_id") == null) {
			return note_repo.getNotes((Users) data.get("user"));
		}
		
		return note_repo.getNoteById((UUID) data.get("note_id"), (Users) data.get("user"));
	}
}
