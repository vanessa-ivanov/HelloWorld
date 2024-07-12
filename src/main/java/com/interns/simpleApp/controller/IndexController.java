package com.interns.simpleApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        System.out.println("Hello");
        return "index";
    }

    @RequestMapping("/register")
    public String userRegistration(){
        return "register";
    }

    @RequestMapping("/login")
    public String userLogin(){
        return "login";
    }
}
