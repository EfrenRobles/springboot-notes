package api.notes.request.notes;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.NonNull;

import com.sun.istack.Nullable;

public class NotesPatchCustomRequest extends NotesPostCustomRequest {

	@Valid
	private UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
