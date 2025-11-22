package pojos;

import org.springframework.stereotype.Component;

import interfaces.Ruler;

@Component
public class PlasticRuler implements Ruler {

	@Override
	public void measuring() {
		System.out.println("Measuring by plastic ruler...");
	}

}
