package Mappings.DTO.Bi.M2M.Students2Subjects2DTO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Students2 implements Serializable {
	@Id
	private int id;
	private String name;
	private String email;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "stud_id"), inverseJoinColumns = @JoinColumn(name = "sub_id"))
	private List<Subjects2> subjects;
}
