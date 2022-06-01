package api.notes.entities;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UsersEntiry {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID userId;

	@Column(name = "user_email", nullable = false, unique = true)
	private String userName;

	@Column(name = "user_password", nullable = false)
	private String userPassword;

	@CreationTimestamp
	@Column(name = "created_at")
	private Timestamp createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private Timestamp updatedAt;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	private Set<NotesEntity> notes;

	private String token;

}
