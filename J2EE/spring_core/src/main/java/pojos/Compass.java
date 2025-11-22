package pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import interfaces.Ruler;
import lombok.Data;
import lombok.Getter;

@Component
@Getter
public class Compass {
	@Autowired
	//@Qualifier("steelRuler") // to avoid UnsatisfiedDependencyException
	private Ruler ruler;
	
	//or 
	
	//with setter
	@Autowired
	@Qualifier("plasticRuler")
	public void setRuler(Ruler ruler) {
		this.ruler = ruler;
	}
	
	//or 
	
	//with contructor
	@Autowired
	public Compass(@Qualifier("steelRuler") Ruler ruler) {
		super();
		this.ruler = ruler;
	}
	
}
