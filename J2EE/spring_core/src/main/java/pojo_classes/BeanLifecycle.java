package pojo_classes;

public class BeanLifecycle {
	
	public BeanLifecycle() {
		System.out.println("Constructor is called");
	}
	public void postConstruct() {
		System.out.println("This method will be executed after DI(after constructor execution)");
	}
	public void preDestruct() {
		System.out.println("This method will be executed just before container is closed/bean is destroyed");
	}
}
