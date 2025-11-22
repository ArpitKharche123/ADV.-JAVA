package driver_class;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo_classes.Product;

public class ProductDriver {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= new ClassPathXmlApplicationContext("Configuration_Files/config.xml");
		
		Product product=(Product) context.getBean("product");
		
		System.out.println("Name: "+product.getName());
		System.out.println("Brand: "+product.getBrand());
		System.out.println("Cost: "+product.getCost());

	}

}
