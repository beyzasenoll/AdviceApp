package com.adviceapp.adviceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login"; // Uygulama başladığında "/login" sayfasına yönlendir
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html sayfasını döndürür
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "index"; // index.html sayfasını döndürür
    }
}
