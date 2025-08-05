package UnderstandingMultiThreading;

public class ThreadsUsingLamdaExpression {
	public static void main(String[] args) {
		//Thread Creation
		Thread t1=new Thread(
				//Lambda expression
				//acts as run() method
				()->{
					for(int i=0;i<100;i++) {
						System.out.print(i);
					}
				}
				);
		
		t1.start();//Executes the above logic written in lambda expression
	}
}
