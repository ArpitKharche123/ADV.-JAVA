package Drivers;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config_classes.ConfigClass;
import pojos.Bag;
import pojos.Book;

public class BagAndBookDriver {
	public static void main(String[] args) {
		ConfigurableApplicationContext context= new AnnotationConfigApplicationContext(ConfigClass.class);
		
		Bag bag=(Bag)context.getBean("bag");
		
		Book book=bag.getBook();
		
		book.read();
	}
}
