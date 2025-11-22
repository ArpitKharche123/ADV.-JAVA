package Drivers;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojos.Car;

public class CarDriver {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("Configuration_Files/minimal_config.xml");
		
		Car car=(Car)context.getBean("car");
		System.out.println("Brand: "+car.getBrand());
		System.out.println("Model: "+car.getModel());
		car.running();
	}

}
