package Mappings.DTO.Bi.O2O.CarEngineDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Engine2 {
	@Id // Primary Key in Engine table, and Foreign Key in Car table
	private int id;
	private String type;
	private int cc;

	// @OneToOne //Foreign key column will be created in Car table
	@OneToOne(mappedBy = "engine")
	private Car2 car;
}
