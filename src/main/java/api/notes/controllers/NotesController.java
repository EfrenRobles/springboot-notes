package api.notes.controllers;

import java.util.LinkedHashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.notes.entities.UsersEntiry;
import api.notes.request.notes.NotesPatchCustomRequest;
import api.notes.request.notes.NotesPostCustomRequest;
import api.notes.services.NotesService;
import api.notes.services.UsersService;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController extends BaseResponse {

	@Autowired
	private UsersService userService;	
	
	@Autowired
	private NotesService noteService;	


	@GetMapping
	public ResponseEntity<?> getNote(HttpServletRequest request) {
		return onSuccess(noteService.getNotesFromUser(userService.getUserByToken(request)), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getNote(@PathVariable UUID id, HttpServletRequest request) {
		return onSuccess(noteService.getNotesFromUserWithId(id, userService.getUserByToken(request)), HttpStatus.OK);
	}
		
	@PostMapping
	public ResponseEntity<?> postNote(@Valid @RequestBody NotesPostCustomRequest input, HttpServletRequest request) {
		return onSuccess(noteService.add(input, userService.getUserByToken(request)), HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<?> patchNote(@PathVariable UUID id, @Valid @RequestBody NotesPatchCustomRequest input, HttpServletRequest request) {

		Object result = noteService.update(id, input, userService.getUserByToken(request));
		
		if (result == null) {
			return onFail("Note does not exist", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		return onSuccess(
			result,
			HttpStatus.OK
		);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletehNote(@PathVariable UUID id, HttpServletRequest request) {

		Object result = noteService.deleteByIdWithUser(id, userService.getUserByToken(request));
		
		if (result == null) {
			return onFail("Note does not exist", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		return onSuccess(
			result,
			HttpStatus.NO_CONTENT
		);
	}

}
