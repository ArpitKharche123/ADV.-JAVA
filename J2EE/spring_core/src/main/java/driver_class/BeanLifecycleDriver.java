package driver_class;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo_classes.BeanLifecycle;

public class BeanLifecycleDriver {

	public static void main(String[] args) {
		System.out.println("Start");
		
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("Configuration_Files/config.xml");
		//This will trigger contructor and postConstruct()
		
		BeanLifecycle beanLifecycle=(BeanLifecycle)context.getBean("bean_life_cycle");
		System.err.println(beanLifecycle);
		
		context.close();//this will triger preDestruct()!!
		
		System.out.println("End");

	}

}
