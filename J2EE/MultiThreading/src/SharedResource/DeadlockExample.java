package SharedResource;

public class DeadlockExample {
	
	//Resources
	static DeadlockExample resource1=new DeadlockExample();
	static DeadlockExample resource2=new DeadlockExample();
	
	public static void main(String[] args) {
		
		//Threads
		Thread thread1=new Thread(
				()->{
					//Thread 1 locking resource 1
					synchronized (resource1) {
						System.out.println("Resource 1 is locked by Thread 1");
						
						//Thread 1 trying to lock resource 2 after locking resource 1
						//This will never execute because resource 2 is already locked by Thread 2!!!
						//THREAD 1 WILL WAIT FOR INDEFINITE TIME FOR RESOURCE 2
						synchronized (resource2) {
							System.out.println("Thread 1 locked Resource 2");
						}
						
					}
				}
				);
		Thread thread2=new Thread(
				()->{
					//Thread 2 locking resource 2
					synchronized (resource2) {
						System.out.println("Resource 2 is locked by Thread 2");
						
						//Thread 2 trying to lock resource 1 after locking resource 2
						//This will never execute because resource 1 is already locked by Thread 1!!!
						//THREAD 2 WILL WAIT FOR INDEFINITE TIME FOR RESOURCE 1
						synchronized (resource1) {
							System.out.println("Thread 2 locked Resource 1");
						}
					}
				}
				);
		
		thread1.start();
		thread2.start();
		
		//This program will never terminate and will keep running
		//(Red pause button will be visible in console)
		
	}
}
