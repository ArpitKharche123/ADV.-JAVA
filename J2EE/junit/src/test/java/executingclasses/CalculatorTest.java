package executingclasses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalculatorTest {

 Calculator calculator=new Calculator();
 
	//@Test
    @Disabled
	void testAdd() {
		int a=20,b=10;
		
		int expectedValue=a+b;
		
		assertEquals(expectedValue,calculator.add(a, b) );
	}

	@Test
	void testSubstract() {
		int a=20,b=10;
		
		int expectedValue=a-b;
		
		assertEquals(expectedValue, calculator.substract(a, b));
	}

	@Test
	void testMultiply() {
		int a=20,b=10;
		int expectedValue=a*b;
		
		assertEquals(expectedValue, calculator.multiply(a, b));
	}

	@Test
	void testDivide() {
		int a=20,b=10;
		
		int expectedValue=a/b;
		
		assertEquals(expectedValue, calculator.divide(a, b));
	}

	@Test
	void testModulus() {
		int a=20,b=10;
		
		int expectedValue=a%b;
		
		assertEquals(expectedValue, calculator.modulus(a, b));
	}
	
	@Test
	void testIsNegative() {
		int a=-10;
		assertTrue(calculator.isNegative(a));
	}

}
