package api.notes.usecase.notes;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import api.notes.dto.NotesDto;
import api.notes.usecase.BaseUseCaseInterface;

@Configuration
public class NotesPostUseCase implements BaseUseCaseInterface {

	@Autowired
	private NotesDto note_repo;

	@Override
	public LinkedHashMap<String, Object> run(LinkedHashMap<String, Object> data) {
		return note_repo.createNote(data);
	}

}
