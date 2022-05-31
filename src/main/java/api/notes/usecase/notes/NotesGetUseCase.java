package api.notes.usecase.notes;

import java.util.LinkedHashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import api.notes.dto.NotesDto;
import api.notes.entities.UsersEntiry;
import api.notes.usecase.BaseUseCaseInterface;

@Configuration
public class NotesGetUseCase implements BaseUseCaseInterface {

	@Autowired
	private NotesDto note_repo;

	@Override
	public LinkedHashMap<String, Object> run(LinkedHashMap<String, Object> data) {
		if (data.get("note_id") == null) {
			return note_repo.getNotes((UsersEntiry) data.get("user"));
		}
		
		return note_repo.getNoteById((UUID) data.get("note_id"), (UsersEntiry) data.get("user"));
	}
}
