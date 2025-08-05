package UnderstandingMultiThreading;

//This class will act as a Thread Class
class ThreadA extends Thread{
	
	//run()
	//Code to be executed by Thread is present in this method
	@Override
	public void run() {
		System.out.println("Dog is barking..");
		for(int i=0;i<100;i++) {
			System.out.print("Bhow... ");
		}
		System.out.println();
	}
}

//This class will act as a Thread Class
class ThreadB extends Thread{
	@Override
	public void run() {
		System.out.println("Cat is meowing...");
		for(int i=0;i<100;i++) {
			System.out.print("Meow... ");
		}
		System.out.println();
	}
}

public class UsingThreadClass {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main thread start");
		
		//Creating Thread Objects
		ThreadA t1=new ThreadA();
		ThreadB t2=new ThreadB();
		
		//Setting Thread Properties
		t1.setName("Dog Thread");//Sets Thread Name
		t1.setPriority(10);//Sets Thread Priority
		// 1-> Minimum
		//5-> Default Priority
		//10-> Maximum
		
		//Fetching the Thread Properties
		System.out.println("ThreadA name: "+t1.getName());
		System.out.println("ThreadA Priority: "+t1.getPriority());
		System.out.println("ThreadA Id: "+t1.threadId());
		
		System.out.println("ThreadB Name: "+t2.getName());//Prints Default name
		System.out.println("ThreadB Priority: "+t2.getPriority());//Prints Default Priority
		
		
	//start()
	//This method will internally call run() method
	//in new thread
	// All the Threads will execute in different stacks, INDEPENDENT OF EACH OTHER
	
	//Used to achieve MultiThreading between multiple threads!!!
		t1.start();
		t2.start();
		
		
		Thread.sleep(5000);//main method will wait(paused) for 5 seconds
		
		System.out.println("No. of active threads: "+Thread.activeCount());
		
		System.out.println("Current executing Thread: "+Thread.currentThread());
	
		System.out.println("main thread end");
	}

}
