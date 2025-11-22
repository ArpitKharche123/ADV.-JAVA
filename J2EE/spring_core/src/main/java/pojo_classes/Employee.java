package pojo_classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //for setter injection

//for constructor injection
@NoArgsConstructor //required for bean instantiation
@AllArgsConstructor  
public class Employee {
	private String name,emp_id,blood_group;
	private int age;
}
