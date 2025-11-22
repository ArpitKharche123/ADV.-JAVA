package Drivers;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config_classes.ConfigClass;
import interfaces.Ruler;
import pojos.Compass;

public class CompassDriver {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= new AnnotationConfigApplicationContext(ConfigClass.class);

		Compass compass=(Compass)context.getBean("compass");
		
		Ruler ruler=compass.getRuler();
		ruler.measuring();
	}

}
