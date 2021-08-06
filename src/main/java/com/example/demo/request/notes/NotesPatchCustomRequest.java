package com.example.demo.request.notes;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.NonNull;

import com.sun.istack.Nullable;

public class NotesPatchCustomRequest {

	@Valid
	private UUID id;

	@NotBlank
	@Length(max = 50)
	private String title;

	@Nullable
	@Length(max = 1000)
	private String note;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
