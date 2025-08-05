package executingclasses;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Annotations {
	
	@AfterAll
	//real time e.g.: closing the connections
	static void afterAll() {
		System.out.println("This method will execute after all the test methods: @AfterAll");
	}
	
	@BeforeAll
	// real time e.g.: establish the connection
	static void beforeAll() {
		System.out.println("This method will execute before all the test methods: @BeforeAll");
	}
	
	@BeforeEach
	void beforeEach() {
		System.err.println("This method will execute before each test method: @BeforeEach");
	}
	
	@AfterEach
	void afterEach() {
		System.err.println("This method will execute after each test method: @AfterEach");
	}
	
	@RepeatedTest(3)
	void repeatedTestMethod() {
		System.out.println("***** This method will execute repeatedly *****");
	}
	
	@Test
	void normalTest1() {
		System.out.println("Normal Test Method 1");
	}
	
	@Test
	void normalTest2() {
		System.out.println("Normal Test Method 2");
	}
	
	@Test
	void normalTest3() {
		System.out.println("Normal Test Method 3");
	}
	

}
