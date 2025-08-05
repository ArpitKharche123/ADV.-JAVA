package SharedResource;

public class AvoidingDeadLock {
	
	//Resources
	static AvoidingDeadLock resource1=new AvoidingDeadLock();
	static AvoidingDeadLock resource2=new AvoidingDeadLock();
	
public static void main(String[] args) {

	//Threads
	Thread thread1=new Thread(
			()->{
				//Thread locking resource1
				synchronized (resource1) {
					System.out.println("Resource 1 is locked by Thread 1");
					
					//Thread 1 trying to lock resource 2
					//This will execute as resource 2 is not locked by Thread 2
					synchronized (resource2) {
						System.out.println("Thread 1 locked Resource 2 after releasing Resource 1");
					}
				}
			}
			);
	Thread thread2=new Thread(
			()->{
				//Fixing Deadlock Problem
				//Locking resources in same order as Thread1
				
				//Thread 2 locking resource 1
				synchronized (resource1) {
					System.out.println("Resource 1 is locked by Thread 2");
					
					//Thread 2 trying to lock resource 2
					//This will execute as resource 2 is not locked by Thread 2
					synchronized (resource2) {
						System.out.println("Thread 2 locked Resource 2 after releasing Resource 1");
					}
				}
			}
			);
	
	thread1.start();
	thread2.start();
	
	//This program will complete its execution as there will be no deadlock!!!
	
}
}
