package driver_class;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo_classes.Mobile;
import pojo_classes.Person;

public class PersonMobileDriver {
	public static void main(String[] args) {
		//Injection using setter
		ConfigurableApplicationContext context= new ClassPathXmlApplicationContext("Configuration_Files/setter_injection_config.xml");
		
		Mobile mobile=(Mobile)context.getBean("mobile_id");
		mobile.ringing();
		System.out.println("----------------");
		Person person=(Person)context.getBean("person");
		person.calling();
		
		System.out.println("----------------------");
		
		//Injection using constructor
				ConfigurableApplicationContext context2= new ClassPathXmlApplicationContext("Configuration_Files/injection_by_constructor_config.xml");
				
				Mobile mobile2=(Mobile)context2.getBean("mobile_id");
				mobile2.ringing();
				System.out.println("----------------");
				Person person2=(Person)context2.getBean("person");
				person2.calling();
	}
}
