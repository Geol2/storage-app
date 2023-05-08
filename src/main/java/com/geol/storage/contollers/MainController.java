package com.geol.storage.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/")
	public ModelAndView root(Model model) {

		ModelAndView mav = new ModelAndView("main/main");
		model.addAttribute("data", "hello!");

		return mav;
	}

}
