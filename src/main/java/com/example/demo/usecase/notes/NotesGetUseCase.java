package com.example.demo.usecase.notes;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.models.Users;
import com.example.demo.repositories.NotesRepository;
import com.example.demo.usecase.BaseUseCaseInterface;

@Configuration
public class NotesGetUseCase implements BaseUseCaseInterface {

	@Autowired
	private NotesRepository note_repo;
	
	public NotesGetUseCase(NotesRepository note_repo) {
		this.note_repo = note_repo;
	}
	
	@Override
	public HashMap<String, Object> run(HashMap<String, Object> data) {
		if (data.get("note_id") == null) {
			return note_repo.getNotes((Users) data.get("user"));
		}
		
		return note_repo.getNoteById((UUID) data.get("note_id"), (Users) data.get("user"));
	}
}
