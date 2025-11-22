package Mappings.DTO.Unidirectional.OneToOne.CarToEngineDTO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
	@Id
	private int id;
	private String name;
	private double cost;

	// @OneToOne(fetch = FetchType.LAZY) //Foreign key column will be created in Car
	// table

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	private Engine engine;
}
