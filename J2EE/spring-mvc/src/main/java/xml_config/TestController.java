package xml_config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/hii")
	public String demoMethod() {
		return "Demo.jsp";
	}
}
