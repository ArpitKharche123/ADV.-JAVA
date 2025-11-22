package pojo_classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	//injecting Mobile type of reference
	private Mobile mobile;
	
	public void calling() {
		System.out.println("Person is calling...");
		mobile.ringing();
	}
}
