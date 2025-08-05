package executingclasses;

public class TestingManually {

	static int add(int a,int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		
		int a=10,b=20;
		
		int expectedValue = a+b;
		
		int actualValue=add(10,20);
		
		if(actualValue==expectedValue) {
			System.out.println("Testing is successful");
		}
		else {
			System.err.println("Testing failed");
		}
		

	}

}
