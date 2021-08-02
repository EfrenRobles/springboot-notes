package com.example.demo.usecase.notes;

import java.util.HashMap;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repositories.NotesRepository;
import com.example.demo.usecase.BaseUseCaseInterface;

@Configuration
public class NotesPostUseCase implements BaseUseCaseInterface {

	private NotesRepository note_repo;

	public NotesPostUseCase(NotesRepository note_repo) {
		this.note_repo = note_repo;
	}

	@Override
	public HashMap<String, Object> run(HashMap<String, Object> data) {
		return note_repo.createNote(data);
	}

}
