package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.loginData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    //ACHTUNG WENN MEHR ALS 10 USER!
    User[] users = new User[10];
    int userNumber = 0;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/register")
    public String userRegistration(){
        return "register";
    }

    @RequestMapping("/registerInput")
    public String userRegistrationInput(@ModelAttribute User user, Model model) {
        System.out.println(user.toString());
        users[userNumber] = new User(user.getFname(),
                                     user.getLname(),
                                     user.getEmail(),
                                     user.getPasswd(),
                                     user.getDob(),
                                     user.getGender()
        );
        model.addAttribute("firstname", user.getFname());
        model.addAttribute("lastname", user.getLname());
        userNumber += 1;
        return "welcome";

    }

    @RequestMapping("/login")
    public String userLogin(){
        return "login";
    }
    @RequestMapping("/loginInput")
    public String userLoginInput(@ModelAttribute loginData login, Model model) {
         for (User existingUser : users) {
            if (existingUser.getEmail().equals(login.getLogEmail()) && existingUser.getPasswd().equals(login.getLogPasswd())){
                model.addAttribute("firstname", existingUser.getFname());
                model.addAttribute("lastname", existingUser.getLname());
                return "welcome";
            }
        }
        return "login";
    }

    @PostMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
}
