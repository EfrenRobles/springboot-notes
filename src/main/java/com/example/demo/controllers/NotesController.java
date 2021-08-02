package com.example.demo.controllers;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.usecase.notes.NotesGetUseCase;
import com.example.demo.usecase.notes.NotesPostUseCase;

@RestController
@RequestMapping("notes")
public class NotesController extends BaseController{

	@Autowired
	private NotesGetUseCase notes_get_usecase;

	@Autowired
	private NotesPostUseCase notes_post_usecase;

	public NotesController(NotesGetUseCase notes_get_usecase, NotesPostUseCase notes_post_usecase) {
		this.notes_get_usecase = notes_get_usecase;
		this.notes_post_usecase = notes_post_usecase;
	}

	@GetMapping
	public ResponseEntity<?> getNote(@RequestParam(required = false) UUID note_id, @RequestParam UUID user_id) {
		HashMap<String, Object> data = new HashMap<>();
		data.put("note_id", note_id);
		data.put("user_id", user_id);
		
		return this.returnResult(notes_get_usecase.run(data), 200);
	}

	 @PostMapping
	 public ResponseEntity<?> postNote(@RequestBody HashMap<String, Object> request, @RequestParam UUID user_id) {
		HashMap<String, Object> data = new HashMap<>();
		data.put("user_id", user_id);
		data.put("note_title", request.get("note_title"));
		data.put("note_message", request.get("note_message"));
		 
		System.out.println(data);
		return this.returnResult(notes_post_usecase.run(data), 201);
	 }
	 
}
