package annotation_config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@GetMapping("/home")
	public String displayHomePage() {
		return "home.jsp";
	}

	// Binding data(passing data to jsp page) using model
	@GetMapping("/model")
	public String displayModelData(Model model) {
		model.addAttribute("name", "Arpit");// key and value
		model.addAttribute("message",
				"This is the tutorial of how to pass data from controller to Web using Model Interface!!");
		return "model.jsp";
	}

	// Binding data(passing data to jsp page) using ModelMap
	@GetMapping("/modelmap")
	public String displayModelMapData(ModelMap map) {
		map.put("Version", 10.1);
		map.put("status", "new");

		Map<String, Integer> info = new LinkedHashMap<>();
		info.put("RAM", 8);
		info.put("ROM", 256);
		info.put("Mah", 7000);

		map.addAllAttributes(info);
		return "modelMap.jsp";
	}

	// Binding data(passing data to jsp page) using ModelAndView
	@GetMapping("/modelandview")
	public ModelAndView displayModelAndViewData() {
		ModelAndView mav = new ModelAndView("model-view.jsp");
		mav.addObject("Car", "BMW");
		mav.addObject("CC", "800");

		return mav;
	}

	// Handling Form Data

	@PostMapping("/register")
	public String registerStudent(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("age") int age, 
			@RequestParam("gender") String gender, Model model) {


		// Setting values to model
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		model.addAttribute("gender", gender);

		return "success.jsp";

	}
}
