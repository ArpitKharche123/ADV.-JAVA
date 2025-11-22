package CRUD;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee implements Serializable {
	@Id
	private int eid;
	private String ename;
	private String email;
	private String bloodGroup;

	@Override
	public String toString() {
		return "eid = " + eid + "\nename = " + ename + "\nemail = " + email + "\nbloodGroup = " + bloodGroup + "\n";
	}

}

//@Data //Generates getters, setters, 
//constructors (RequiredArgsConstructor)

/*
 * @RequiredArgsConstructor generates a constructor only for fields that are:
 * 
 * Declared as final, OR
 * 
 * Annotated with @NonNull.
 */
//and overrides toString(),equals() and hashcode()
