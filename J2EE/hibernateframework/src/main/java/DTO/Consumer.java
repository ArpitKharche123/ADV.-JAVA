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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Consumer implements Serializable{
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	//To create a custom sequence
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "con")
	@SequenceGenerator(name = "con",
	initialValue = 1, //starting value
	allocationSize = 10,// by how much to increase
	sequenceName = "consumer_sequece_info")//name of sequence table
	private int id;
	
	private String name;
	
	
}
