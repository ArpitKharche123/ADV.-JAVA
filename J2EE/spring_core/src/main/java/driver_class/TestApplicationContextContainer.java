package driver_class;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo_classes.Demo;
import pojo_classes.Person;

public class TestApplicationContextContainer {

	public static void main(String[] args) {
		
		//Core interface of Spring IOC Container
		ApplicationContext context=new ClassPathXmlApplicationContext("Configuration_Files/config.xml");
		//name of configuration file
		
		//or
		
		//Child of ApplicationContext with some
		//extra lifecycle handling methods
		
		//Loading the config file
		//ConfigurableApplicationContext context2=new ClassPathXmlApplicationContext("confiig.xml");
		
		//Fetching Person class object/bean created by IOC container
		Demo demo=(Demo)context.getBean("person");//pass same value passed in id of bean tag in config.xml
		
		//Using the bean
		demo.message();

	}

}
