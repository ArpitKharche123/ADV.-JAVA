package SharedResource;

class Counter{
	int count=0;
	//Shared Resource
	void increment() {
		count++;
	}
}

public class Asynchronization {
	
	public static void main(String[] args) throws InterruptedException {
		
		Counter counter=new Counter();
		
		//t1 and t2 may switch the resource multiple times in between
		//while program is running
		Thread t1=new Thread(
				()->{
					for(int i=0;i<1000;i++) {
						counter.increment();
					}
				}
				);
			
		Thread t2=new Thread(
				()->{
					for(int i=0;i<1000;i++) {
						counter.increment();
					}
				}
				);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		//Inconsistent/Inaccurate Data can be printed
		System.out.println("Count Value: "+counter.count);

	}

}
