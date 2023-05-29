package com.geol.storage.contollers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
    @PostMapping("/login")
    public void postLogin(HttpServletRequest request) {
        String userId = request.getParameter("uid");
        String passWd = request.getParameter("pwd");
    }

    @GetMapping("/login")
    public ModelAndView getLogin(HttpServletRequest request, Model model) {

        ModelAndView mav = new ModelAndView("main/login");
        model.addAttribute("data", "hello!");

        return mav;
    }
}
