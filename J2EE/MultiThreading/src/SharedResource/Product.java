package SharedResource;

public class Product {
	int quantity;
	
	//Consumer will call this method
	public synchronized void consume() {
		if(quantity>0) {
			quantity--;
			System.out.println("Product is consumed!!. Current Quantity:"+ quantity);
		}
		else {
			try {
				//it product is not available(0 quantity)
				//Consumer Thread will wait(paused) till notified by notify() method
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Producer will call this method
	public synchronized void produce() {
		quantity++;
		System.out.println("Product is Produced. Current Quantity: "+quantity);
		
		//Telling Consumer Thread that product is produced and can be consumed
		//notify() will resume the execution of Consumer Thread
		//Which is paused due to wait() method
		notify();
	}
}
