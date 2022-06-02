package api.notes.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import api.notes.entities.NotesEntity;
import api.notes.entities.UsersEntiry;

public interface NotesRepository extends JpaRepository<NotesEntity, UUID> {
	public NotesEntity findByNoteIdAndUsers(UUID noteId, UsersEntiry user);

	public List<NotesEntity> findByUsers(UsersEntiry user);
}
