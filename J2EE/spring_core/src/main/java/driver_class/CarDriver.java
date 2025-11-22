package driver_class;

import java.util.List;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo_classes.Car;

public class CarDriver {

	public static void main(String[] args) {
		
		//Injection using setter
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("Configuration_Files/setter_injection_config.xml");
		
		Car car=(Car)context.getBean("car");
		System.out.println("Model: "+car.getModel());
		System.out.println("Brand: "+car.getBrand());
		System.out.println("\nTyres:\n ");
		List<String> tyres=car.getTyres();
		for(String tyre: tyres) {
			System.out.println(tyre);
		}

		System.out.println("\nPrice Range:\n");
		Map<String, Double> variant_prices=car.getPrice();
		for(Map.Entry<String, Double> variant_price: variant_prices.entrySet()) {
			System.out.println(variant_price.getKey()+"-->"+variant_price.getValue()+" Rs");
		}
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		//Injection using Constructor
				ConfigurableApplicationContext context2=new ClassPathXmlApplicationContext("Configuration_Files/injection_by_constructor_config.xml");
				
				Car car2=(Car)context2.getBean("car");
				System.out.println("Model: "+car2.getModel());
				System.out.println("Brand: "+car2.getBrand());
				System.out.println("\nTyres:\n ");
				List<String> tyres2=car2.getTyres();
				for(String tyre: tyres2) {
					System.out.println(tyre);
				}

				System.out.println("\nPrice Range:\n");
				Map<String, Double> variant_prices2=car2.getPrice();
				for(Map.Entry<String, Double> variant_price: variant_prices2.entrySet()) {
					System.out.println(variant_price.getKey()+"-->"+variant_price.getValue()+" Rs");
				}
	}

}
