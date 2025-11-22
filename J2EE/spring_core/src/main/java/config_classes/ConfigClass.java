package config_classes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import pojos.Duster;

@Configuration
@ComponentScan(basePackages = {"pojos", "pojo_classes"})
@PropertySource("classpath:prod_info.properties")
public class ConfigClass {

	//Assuming Duster class is written by some third person, and we dont have access to it
 
	//factory method to return POJO object
	
	@Bean("duster") 	//bean name/id
	@Scope("prototype") // new object will be created for each call of getBeans()
	public Duster getDuster() {
		return new Duster();
	}
	
}
