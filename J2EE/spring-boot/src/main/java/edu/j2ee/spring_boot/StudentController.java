package edu.j2ee.spring_boot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@PostMapping("/student")
	public String studentInfo(@RequestBody Student student) {
		return
				"Id: "+student.getId()+"\n"+
				"Name: "+student.getName()+"\n"+
				"Height: "+student.getHeight()+"\n"
				;
	}
}
