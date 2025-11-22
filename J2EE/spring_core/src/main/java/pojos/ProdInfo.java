package pojos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProdInfo {
	@Value(value = "${name}")
	private String name;
	@Value("${cost}")
	private double cost;
	@Value("${brand}")
	private String brand;
}
