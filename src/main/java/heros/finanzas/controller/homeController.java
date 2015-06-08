package heros.finanzas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class homeController {
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String defaultRequest()
	{
		return "home";
	}
}
