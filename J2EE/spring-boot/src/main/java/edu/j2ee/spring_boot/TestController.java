package edu.j2ee.spring_boot;

import java.util.UUID;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/get")
	public String get() {
		return "Welcome to SpringBoot 🌿";
	}

	// cannot be triggered on web by default, use Postman to test
	@PostMapping("/post")
	public String postMethod() {
		return "This is a post method";
	}

	// cannot be triggered on web by default, use Postman to test
	@PutMapping("/put")
	public String putMethod() {
		return "This is a put method";
	}
	
	@PatchMapping("/patch")
	public String patchMethod() {
		return "This is patch method";
	}

	// cannot be triggered on web by default, use Postman to test
	@DeleteMapping("/delete")
	public String deleteMethod() {
		return "This is a delete method";
	}
	
	
	//Passing data using Query String
	@GetMapping("/student")
	public String info(@RequestParam("id") int stud_id, @RequestParam String name, @RequestParam(required = false) String surname) {
		return "Student id: "+stud_id+"\nName: "+name;
	}
	
	//Passing data using Path variable
	@GetMapping("/user/{id}/{name}")
	public String userInfo(@PathVariable("id") int user_id,@PathVariable String name) {
		return "User id: "+user_id+"\nName: "+name;
	}
	
	//Passing data using header parameter
	@GetMapping("/token")
	public String test(@RequestHeader("token") String auth_token) {
		auth_token=UUID.randomUUID().toString();
		return "Token: "+auth_token;
	}
	
	//Passing data using cookies
	@GetMapping("/info")
	public String testCookie(@CookieValue("name") String prod_name,@CookieValue double price) {
		return "Product Name: "+prod_name+"\nPrice: "+price;
	}
}
