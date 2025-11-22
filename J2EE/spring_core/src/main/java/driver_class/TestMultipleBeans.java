package driver_class;

import java.rmi.StubNotFoundException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo_classes.Demo;
import pojo_classes.Person;
import pojo_classes.Student;
import pojo_classes.Teacher;

public class TestMultipleBeans {

	public static void main(String[] args) {
	ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("Configuration_Files/config.xml");
	
	Demo demo=(Demo)context.getBean("demo");
	demo.message();
	
	ConfigurableApplicationContext collegeContext=new ClassPathXmlApplicationContext("Configuration_Files/college_config.xml");
	
	Student s=(Student)collegeContext.getBean("student");
	Teacher t=(Teacher)collegeContext.getBean("teacher");
	
	s.m1();
	t.m1();

	}

}
