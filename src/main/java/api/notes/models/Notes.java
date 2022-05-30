package api.notes.models;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "notes")
public class Notes {
	@Id
	@Column(name = "note_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID noteId;

	@Column(name = "note_title", nullable = false, length = 50)
	private String note_title;

	@Column(name = "note_message", nullable = false, length = 1000)
	private String note_message;

	@CreationTimestamp
	private Timestamp created_at;

	@UpdateTimestamp
	private Timestamp updated_at;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName="user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonBackReference  
	private Users users;

	public UUID getNoteID() {
		return noteId;
	}
	
	public void setNoteID(UUID note_id) {
		this.noteId = note_id;
	}
	
	public String getNoteTitle() {
		return note_title;
	}

	public void setNoteTitle(String note_title) {
		this.note_title = note_title;
	}

	public String getNoteMessage() {
		return note_message;
	}

	public void setNoteMessage(String note_message) {
		this.note_message = note_message;
	}
	
    public Users getUsers()
    {
        return users;
    }

    public void setUsers(Users users)
    {
        this.users = users;
    }

	public Timestamp getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
    
    
    
}
