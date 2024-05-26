package com.adviceapp.adviceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ContentHTMLController {
    @GetMapping("/content")
    public String getContentPage() {
        return "content"; // content.html dosyasının adı
    }

}
