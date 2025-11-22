package pojos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Pen {
	@Value("Trimax")
	private String name;
}
