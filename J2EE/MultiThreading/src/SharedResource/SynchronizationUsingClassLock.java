package SharedResource;
class Counter3{
	static int count=0;
	//Static Shared Resource
	static void increment() {
		synchronized (Counter3.class) {
			count++;
		}
	}
}

public class SynchronizationUsingClassLock {
	public static void main(String[] args) throws InterruptedException {
		
		//t1 and t2 will not switch the resource multiple times 
	    //while program is executing
	    
	    //First either t1 or t2 will completely uses the resource
	    //(completely executed increment() 1000 times)
	    //and then other thread can access the resource.
		Thread t1=new Thread(
				()->{
					for(int i=0;i<1000;i++) {
						Counter3.increment();
					}
				}
				);
			
		Thread t2=new Thread(
				()->{
					for(int i=0;i<1000;i++) {
						Counter3.increment();
					}
				}
				);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		//Accurate Result will be printed
		System.out.println("Count Value: "+Counter3.count);

	}
}
