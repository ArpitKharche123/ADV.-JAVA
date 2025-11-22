package DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bike implements Serializable {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//It will act similar as GenerationType.AUTO in assigning the ids
	
	//Custom strategy similar to GenerationType.IDENTITY
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bike")
	@SequenceGenerator(name = "bike",
	initialValue = 1, //starting value
	allocationSize = 1,// by how much to increase
	sequenceName = "bike_seq")
	private int id;
	private String name;
	private String type;
	
}
