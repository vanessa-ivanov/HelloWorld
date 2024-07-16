package com.interns.simpleApp.controller;

import com.interns.simpleApp.model.LoginData;
import com.interns.simpleApp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    int maxUsers = 2;
    List<User> users = new ArrayList<>();

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
        if (nonOptionalInputMissing(user)) {
            //NOI = Non-Optional Input
            model.addAttribute("NOI", "Please fill all non-optional boxes!");
            return "register";
        }
        if  (passwordsDontMatch(user)){
            //PDM = Passwords Don´t Match
            model.addAttribute("PDM", "Passwords don´t match!");
            return "register";
        }
        if (emailAlreadyUsed(user)) {
            // EAU = Email Already Used
            model.addAttribute("EAU", "An account with this email already exists!");
            return "register";
        }
        if (userLimitReached()) {
            //ULR = User Limit Reached
            model.addAttribute("ULR", "User limit reached!");
            return "register";
        }

        addUser(user);
        System.out.println(users.get(users.size() -1).toString());
        model.addAttribute("firstname", user.getFname());
        model.addAttribute("lastname", user.getLname());
        return "welcome";
    }

    public boolean nonOptionalInputMissing(User user) {
        return user.getFname().isEmpty() ||
                user.getLname().isEmpty()  ||
                user.getEmail().isEmpty()  ||
                user.getPasswd().isEmpty()  ||
                user.getPasswd2().isEmpty()  ||
                user.getDob().isEmpty();
    }

    public boolean passwordsDontMatch(User user){
        return (!(user.getPasswd().equals(user.getPasswd2())));
    }

    public boolean emailAlreadyUsed(User user){
        for (User userEmail : users) {
            return userEmail.getEmail().equals(user.getEmail());
        }
        return false;
    }

    public boolean userLimitReached(){
        return users.size() +1 > maxUsers;
    }

    public boolean noGenderGiven(User user){
        return user.getGender().isEmpty();
    }

    public void addUser(User user) {
        if (noGenderGiven(user)) {
            users.add(new User(user.getFname(), user.getLname(), user.getEmail(), user.getPasswd(), user.getPasswd2(), user.getDob(), "Not given"));
        } else {
            users.add(new User(user.getFname(), user.getLname(), user.getEmail(), user.getPasswd(), user.getPasswd2(), user.getDob(), user.getGender()));
        }
    }

    @RequestMapping("/loginInput")
    public String userLoginInput(@ModelAttribute LoginData login, Model model) {
        for (User userLogin : users) {
            if (successfulLogin(login, userLogin)){
                model.addAttribute("firstname", userLogin.getFname());
                model.addAttribute("lastname", userLogin.getLname());
                return "welcome";
            }
        }
        //NSA = No Such Account
        model.addAttribute("NSA", "No such account!");
        return "login";
    }

    public boolean successfulLogin(LoginData login, User userLogin){
        return userLogin.getEmail().equals(login.getLogEmail()) && userLogin.getPasswd().equals(login.getLogPasswd());
    }

    @RequestMapping("/login")
    public String userLogin(){
        return "login";
    }
}
