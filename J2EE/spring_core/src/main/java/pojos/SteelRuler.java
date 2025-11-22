package pojos;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import interfaces.Ruler;

@Component
@Primary  //alternative for @Qualifier
//Indicates that a bean should be given preference
//when multiple candidates are qualified to autowire a single-valued dependency

//can be used on either one of the component classes out of multiple qualified classes
public class SteelRuler implements Ruler {
	@Override
	public void measuring() {
		System.out.println("Measuring the length..");
	}

}
