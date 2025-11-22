package Mappings.DTO.Bi.O2O.CarEngineDTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Car2 implements Serializable {
	@Id
	private int id;
	private String name;
	private double cost;

	// @OneToOne //Foreign key column will be created in Car table
	@OneToOne
	@JoinColumn(name = "my_engine_id")
	private Engine2 engine;
}
