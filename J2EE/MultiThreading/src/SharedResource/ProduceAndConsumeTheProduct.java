package SharedResource;

public class ProduceAndConsumeTheProduct {

	public static void main(String[] args) {
		
		Product product=new Product();
		
		//Producer Thread
		Thread producer=new Thread(
				()->{
					//Produces 5 products
					for(int i=0;i<5;i++) {
						product.produce();
						//To give time to consumer to consume the product
						try {
							Thread.sleep(1000); //pauses producer thread for 1 second
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				);
		Thread consumer=new Thread(
				()->{
					//Consumes 5 products
					for(int i=0;i<5;i++) {
						product.consume();
					//Giving some time for Producer to produce the product
						try {
							Thread.sleep(1000);//pauses consumer thread for 1 second
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				);
		producer.start();
		consumer.start();
		

	}

}
