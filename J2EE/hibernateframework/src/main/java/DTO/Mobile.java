package DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Mobile implements Serializable {
	@Id

	// @GeneratedValue(strategy = GenerationType.TABLE)

	// Custom strategy similar to identity
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "mob")
	@TableGenerator(name = "mob", initialValue = 0, allocationSize = 1, table = "mob_seq" // sequence table name
	)

	private int id;
	private String brand;
	private double price;
}
