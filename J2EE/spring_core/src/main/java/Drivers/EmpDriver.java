package Drivers;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config_classes.ConfigClass;
import pojos.Emp;

public class EmpDriver {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(ConfigClass.class);
		
		Emp e1=(Emp)context.getBean("emp");
		Emp e2=(Emp)context.getBean("emp");
		Emp e3=(Emp)context.getBean("emp");
		
		//will display same address when scope is not provided(singleton by default)
		//will display different addresses when scope is set to prototype
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);

	}

}
