package driver_class;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo_classes.Employee;

public class EmployeeDriver {

	public static void main(String[] args) {
		
		//Setter injection
		ConfigurableApplicationContext empContext=new ClassPathXmlApplicationContext("Configuration_Files/setter_injection_config.xml");
		Employee emp=(Employee)empContext.getBean("employee");
		System.out.println(
				emp.getEmp_id()+" "+
				emp.getName()+" "+
				emp.getBlood_group()+" "+
				emp.getAge()
				);
		
		System.out.println("---------------------");
		
		//Constructor Injection
		ConfigurableApplicationContext context2=new ClassPathXmlApplicationContext("Configuration_Files/injection_by_constructor_config.xml");
		
		Employee emp2=(Employee)context2.getBean("employee");
		System.out.println(
				emp2.getEmp_id()+" "+
				emp2.getName()+" "+
				emp2.getBlood_group()+" "+
				emp2.getAge()
				);
	}

}
