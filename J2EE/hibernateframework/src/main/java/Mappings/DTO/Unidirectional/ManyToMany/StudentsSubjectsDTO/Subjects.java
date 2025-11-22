package Mappings.DTO.Unidirectional.ManyToMany.StudentsSubjectsDTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subjects implements Serializable {
	@Id
	private int id;
	private String name;
	private int days;

}
