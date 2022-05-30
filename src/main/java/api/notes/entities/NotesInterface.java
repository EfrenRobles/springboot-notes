package api.notes.entities;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesInterface extends JpaRepository<Notes, UUID> {
	public Optional<Notes> findByNoteIdAndUsers(UUID note_id, Users user);

	public List<Notes> findByUsers(Users user);
}
