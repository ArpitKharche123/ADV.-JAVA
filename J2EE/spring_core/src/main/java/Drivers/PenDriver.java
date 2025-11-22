package Drivers;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config_classes.ConfigClass;
import pojos.Pen;

public class PenDriver {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(ConfigClass.class);
		
		Pen pen=(Pen)context.getBean("pen");
		
		System.out.println("Pen Name: "+pen.getName());

	}

}
