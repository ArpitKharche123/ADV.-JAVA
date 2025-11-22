package Mappings.DTO.Unidirectional.ManyToOne.ReviewsToProductDTO;

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
public class Product implements Serializable {
	@Id
	private int id;
	private String name;
	private double cost;
}
