package com.interns.simpleApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class Controller {
    @GetMapping("/")
    public String index() {
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
