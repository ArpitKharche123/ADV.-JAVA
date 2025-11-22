package demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // mandatory
//optional
//@AllArgsConstructor
//@Getter
//@Setter
public class Student implements Serializable {
	@Id
	private int roll;
	private String name;
	private String email;
	private long mobile;

	// Mandatory
	public Student() {
		super();
	}

	// Optional
	public Student(int roll, String name, String email, long mobile) {
		super();
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}
