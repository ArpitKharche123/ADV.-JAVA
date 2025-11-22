package Mappings.DTO.Unidirectional.OneToOne.CarToEngineDTO;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Engine {
	@Id // Primary Key in Engine table, and Foreign Key in Car table
	private int id;
	private String type;
	private int cc;
}
