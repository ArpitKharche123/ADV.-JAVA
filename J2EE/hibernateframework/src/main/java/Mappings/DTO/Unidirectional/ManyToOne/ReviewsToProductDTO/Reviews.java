package Mappings.DTO.Unidirectional.ManyToOne.ReviewsToProductDTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reviews implements Serializable {
	@Id
	private int id;
	private String heading;
	private String message;

	@ManyToOne
	private Product product;
}
