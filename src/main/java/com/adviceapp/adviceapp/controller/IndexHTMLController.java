package com.adviceapp.adviceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexHTMLController {
    @GetMapping("/index")
    public String getIndexPage() {
        return "index"; // index.html dosyasının adı
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login"; // Uygulama başladığında "/login" sayfasına yönlendir
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html sayfasını döndürür
    }
}
