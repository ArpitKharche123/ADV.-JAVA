package Drivers;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config_classes.ConfigClass;
import pojos.ProdInfo;

public class ProdInfoDriver {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(ConfigClass.class);
		
		ProdInfo info=(ProdInfo)context.getBean("prodInfo");
		
		System.out.println("Name: "+info.getName());
		System.out.println("Cost: "+info.getCost());
		System.out.println("Brand: "+info.getBrand());

	}

}
