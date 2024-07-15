package com.interns.simpleApp.controller;

import com.interns.simpleApp.model.LoginData;
import com.interns.simpleApp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
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
        if(user.getFname().equals("") ||
                user.getLname().equals("") ||
                user.getEmail().equals("") ||
                user.getPasswd().equals("") ||
                user.getPasswd2().equals("") ||
                user.getDob().equals("")
        ) {
            //NOI = Non-Optional Input
            model.addAttribute("NOI", "Please fill all non-optional boxes!");
            return "register";
        } else if (!(user.getPasswd().equals(user.getPasswd2()))){
            //PDM = Passwords Don´t Match
            model.addAttribute("PDM", "Passwords don´t match!");
            return "register";
        } else {
            for (User userEmail : users){
                if (userEmail.equals(user.getEmail())){
                    //EAU = Email Already Used
                    model.addAttribute("EAU", "An account with this  email already exists!");
                    return "register";
                }
            }
            if(user.getGender().equals("")){
                users[userNumber] = new User(user.getFname(),
                        user.getLname(),
                        user.getEmail(),
                        user.getPasswd(),
                        user.getPasswd2(),
                        user.getDob(),
                        "Not given"
                );
            } else {
                users[userNumber] = new User(user.getFname(),
                        user.getLname(),
                        user.getEmail(),
                        user.getPasswd(),
                        user.getPasswd2(),
                        user.getDob(),
                        user.getGender()
                );
            }
            System.out.println(users[userNumber].toString());
            model.addAttribute("firstname", user.getFname());
            model.addAttribute("lastname", user.getLname());
            userNumber += 1;
            return "welcome";
        }
    }

    @RequestMapping("/loginInput")
    public String userLoginInput(@ModelAttribute LoginData login, Model model) {
        for (User existingUser : users) {
            if (existingUser.getEmail().equals(login.getLogEmail()) && existingUser.getPasswd().equals(login.getLogPasswd())){
                model.addAttribute("firstname", existingUser.getFname());
                model.addAttribute("lastname", existingUser.getLname());
                return "welcome";
            }
        }
        return "login";
    }

    @RequestMapping("/login")
    public String userLogin(){
        return "login";
    }
}
