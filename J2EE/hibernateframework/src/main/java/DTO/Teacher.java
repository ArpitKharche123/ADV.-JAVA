package DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teacher_info")

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "teacherCache")
public class Teacher implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "t_id", updatable = false)
	private int id;

	@Column(nullable = false, length = 15)
	private String name;

	@NonNull
	@Column(nullable = false, unique = true)
	private String email;

	@Column(name = "mobile_no", nullable = false, unique = true)
	private long phone;

	@Column(name = "created_at")
	@CreationTimestamp
	// Automatically sets the value of the field with the current date/time when the
	// entity is first saved (INSERTED) into the database.
	private LocalDate createdDateTime;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updateDateTime;
}
