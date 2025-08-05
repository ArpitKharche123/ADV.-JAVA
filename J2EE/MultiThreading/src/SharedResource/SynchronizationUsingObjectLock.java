package SharedResource;
class Counter2{
	int count=0;
	//Non-Static Shared Resource
	synchronized void increment() {
		count++;
	}
	
	//or
	
	//Object lock on Non-Static Shared Resource
	void increment2() {
		synchronized (this) {
			count++;
		}
	}
}
public class SynchronizationUsingObjectLock {

	public static void main(String[] args) throws InterruptedException {
    Counter2 counter=new Counter2();
		
    //t1 and t2 will not switch the resource multiple times 
    //while program is executing
    
    //First either t1 or t2 will completely uses the resource
    //(completely executed increment() 1000 times)
    //and then other thread can access the resource.
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
		
		//Accurate Result will be printed
		System.out.println("Count Value: "+counter.count);


	}

}
