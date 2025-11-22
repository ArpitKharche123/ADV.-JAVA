package Mappings.DTO.Bi.M2M.Students2Subjects2DTO;

import java.io.Serializable;
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
public class Subjects2 implements Serializable {
	@Id
	private int id;
	private String name;
	private int days;

	@ManyToMany(mappedBy = "subjects")
	private List<Students2> students;
}
