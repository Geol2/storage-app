package com.geol.storage.contollers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/login")
    public void postLogin(HttpServletRequest request) {
        String userId = request.getParameter("uid");
        String passWd = request.getParameter("pwd");


    }
}
