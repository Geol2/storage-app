package com.geol.storage.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/")
	public ModelAndView root(Model model) {

		ModelAndView mav = new ModelAndView("main/main");
		model.addAttribute("data", "hello!");

		return mav;
	}

	@GetMapping("/view/{fileName}")
	public ModelAndView fileView(Model model,
			@PathVariable("fileName") String fileName) {

		ModelAndView mav = new ModelAndView("main/data");
		model.addAttribute("data", "/data/" + fileName);

		return mav;
	}
}
