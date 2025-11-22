package Drivers;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config_classes.ConfigClass;
import pojos.Duster;

public class DusterDriver {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(ConfigClass.class);
		
		Duster duster=(Duster)context.getBean("duster");
		
		duster.rub();

		Duster duster2=(Duster)context.getBean("duster");
		
		System.out.println(duster+" "+duster2);
	}

}
