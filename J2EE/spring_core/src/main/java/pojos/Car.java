package pojos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.val;

@Component("car")
@Getter

public class Car {
	
	//Injecting value with variable
	@Value("BMW")
	private String brand;
	private String model;

	public void running() {
		System.out.println("Car is running...");
	}

	//Injecting Value with Constructor
	public Car(@Value("BMW") String brand, @Value("GS3000") String model) {
		super();
		this.brand = brand;
		this.model = model;
	}

	//Injecting values with setters
	@Value("Mercedes")
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Value("Maybach")
	public void setModel(String model) {
		this.model = model;
	}
	
	

}
