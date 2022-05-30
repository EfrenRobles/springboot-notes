package api.notes.request.notes;

import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.sun.istack.Nullable;

public class NotesPostCustomRequest {

	@NotBlank
	@Length(max = 50)
	private String title;

	@Nullable
	@Length(max = 1000)
	private String note;

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
