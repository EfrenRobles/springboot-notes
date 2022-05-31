package api.notes.request.notes;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import com.sun.istack.Nullable;
import lombok.Data;

@Data
public class NotesPostCustomRequest {

	@NotBlank
	@Length(max = 50)
	private String title;

	@Nullable
	@Length(max = 1000)
	private String note;
}
