package com.example.demo.usecase.notes;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.models.Notes;
import com.example.demo.models.Users;
import com.example.demo.repositories.NotesRepository;
import com.example.demo.usecase.BaseUseCaseInterface;

@Configuration
public class NotesDeleteUseCase implements BaseUseCaseInterface {

	@Autowired
	private NotesRepository note_repo;

	@Override
	public HashMap<String, Object> run(HashMap<String, Object> data) {
		HashMap<String, Object> result = note_repo.getNoteById((UUID) data.get("note_id"), (Users) data.get("user"));
		
		Optional object_result = (Optional) result.get("result");
		
		if (object_result.isEmpty()) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("status", "ERROR");
			response.put("result", "Note does not exist");
			
			return response;
		}
		
		Notes note = (Notes) object_result.get();
		
		return note_repo.deleteNote(note);
	}
}
