package org.khanacademy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	@RequestMapping({"/about", "/"})
	public String home() {
		return "home";
	}
	
	@RequestMapping("/{viewName}")
	public String genericResolver(@PathVariable("viewName") String viewName) {
		return viewName;
	}
	
}
