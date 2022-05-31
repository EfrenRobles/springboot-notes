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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.notes.request.notes.NotesPatchCustomRequest;
import api.notes.request.notes.NotesPostCustomRequest;
import api.notes.usecase.notes.NotesDeleteUseCase;
import api.notes.usecase.notes.NotesGetUseCase;
import api.notes.usecase.notes.NotesPatchUseCase;
import api.notes.usecase.notes.NotesPostUseCase;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController extends BaseController {

	@Autowired
	private NotesGetUseCase notes_get_usecase;

	@Autowired
	private NotesPostUseCase notes_post_usecase;

	@Autowired
	private NotesPatchUseCase notes_patch_usecase;

	@Autowired
	private NotesDeleteUseCase notes_delete_usecase;

	@GetMapping
	public ResponseEntity<?> getNote(@RequestParam(required = false) UUID id, HttpServletRequest request) {
		LinkedHashMap<String, Object> data = new LinkedHashMap<>();
		data.put("note_id", id);
		data.put("user", getUser(request));

		return this.returnResult(notes_get_usecase.run(data), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> postNote(@Valid @RequestBody NotesPostCustomRequest input, HttpServletRequest request) {
		LinkedHashMap<String, Object> data = new LinkedHashMap<>();
		data.put("user", getUser(request));
		data.put("note_title", input.getTitle());
		data.put("note_message", input.getNote());

		return this.returnResult(notes_post_usecase.run(data), HttpStatus.ACCEPTED);
	}

	@PatchMapping
	public ResponseEntity<?> patchNote(@Valid @RequestBody NotesPatchCustomRequest input, HttpServletRequest request) {
		LinkedHashMap<String, Object> data = new LinkedHashMap<>();
		data.put("user", getUser(request));
		data.put("note_id", input.getId());
		data.put("note_title", input.getTitle());
		data.put("note_message", input.getNote());

		return this.returnResult(notes_patch_usecase.run(data), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deletehNote(@RequestParam UUID id, HttpServletRequest request) {
		LinkedHashMap<String, Object> data = new LinkedHashMap<>();
		data.put("user", getUser(request));
		data.put("note_id", id);

		return this.returnResult(notes_delete_usecase.run(data), HttpStatus.NO_CONTENT);
	}

}
