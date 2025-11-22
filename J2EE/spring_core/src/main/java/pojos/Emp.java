package pojos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")// new object will be created for each call of getBeans()
public class Emp {
	
}
