package api.notes.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import api.notes.entities.UsersEntiry;

public interface UsersRepository extends JpaRepository<UsersEntiry, UUID> {
	public UsersEntiry findByUserName(String user_name);
}
