package Mappings.DTO.Unidirectional.ManyToMany.StudentsSubjectsDTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Students {
	@Id
	private int id;
	private String name;
	private String email;

	@ManyToMany // many students has many subjects
	private List<Subjects> subjects;
}
