package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String indexGet(Model model) {
        return "index"; 
    }

    @GetMapping("/test")
    public String testGet(Model model) {
        return "test";  
    }

    @GetMapping("/testconn")
    public String testget(Model model) {
        return "testconn";  
    }
}
