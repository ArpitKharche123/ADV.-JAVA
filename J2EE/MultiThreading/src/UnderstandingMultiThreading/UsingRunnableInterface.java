package UnderstandingMultiThreading;

//This class will act as a Thread Class
class Thread1 implements Runnable{
	
	//run()
	//Code to be executed by Thread is present in this method
	@Override
	public void run() {
		System.out.println("Dog is barking..");
		for(int i=0;i<100;i++) {
			System.out.print("Bhow.... ");
		}
		System.out.println();
	}
}

//This class will act as a Thread Class
class Thread2 implements Runnable{
	@Override
	public void run() {
		System.out.print("Cat is meowing...");
		for(int i=0;i<100;i++) {
			System.out.print("Meow... ");
		}
		System.out.println();
	}
	
}

public class UsingRunnableInterface {

	//main thread
	public static void main(String[] args) {
		System.out.println("main thread start");
		
		//Creating objects of User Defined Classes Thread1 and Thread2
		Thread1 thread1=new Thread1();
		Thread2 thread2=new Thread2();
		
		//Directly calling run() will not start the new thread
		//It will act like a normal method, and all threads will execute in
		// main method stack!!!(NOT INDEPENDENTLY!!!)
		
//		thread1.run();
//		thread2.run();
		
		//Creating Object of Type Thread
		Thread threadobj1=new Thread(thread1);
		Thread threadobj2=new Thread(thread2);
		
		//start()
		//This method will internally call run() method
		//in new thread
		// All the Threads will execute in different stacks, INDEPENDENT OF EACH OTHER
		
		//Used to achieve MultiThreading between multiple threads!!!
		
		threadobj1.start();
		threadobj2.start();
		
		System.out.println("main thread end");
	}

}
