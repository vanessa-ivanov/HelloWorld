package com.interns.simpleApp.controller;

import com.interns.simpleApp.model.LoginData;
import com.interns.simpleApp.model.User;
import com.interns.simpleApp.model.Vacation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class IndexController {

    int maxUsers = 2;
    List<User> users = new ArrayList<>();
    User activeUser;

    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @GetMapping("/")
    public String index() {
        logger.setLevel(Level.ALL);
        logger.info("USER ENTERED START PAGE");

        return "index";
    }

    @RequestMapping("/register")
    public String userRegistration() {
        return "register";
    }

    @RequestMapping("/registerInput")
    public String userRegistrationInput(@ModelAttribute User user, Model model) {
        logger.setLevel(Level.ALL);
        logger.info("USER TRYING TO REGISTER");
        if (nonOptionalInputMissing(user)) {
            //NOI = Non-Optional Input
            model.addAttribute("NOI", "Please fill all non-optional boxes!");
            logger.warning("REGISTER FAILED!");
            return "register";
        }
        if  (passwordsDontMatch(user)) {
            //PDM = Passwords Don´t Match
            model.addAttribute("PDM", "Passwords don´t match!");
            logger.warning("REGISTER FAILED!");
            return "register";
        }
        if (emailAlreadyUsed(user)) {
            // EAU = Email Already Used
            model.addAttribute("EAU", "An account with this email already exists!");
            logger.warning("REGISTER FAILED!");
            return "register";
        }
        if (userToYoung(user)){
            model.addAttribute("TY", "You have to be at least 18 years old!");
            logger.warning("REGISTER FAILED!");
            return "register";
        }
        if (userLimitReached()) {
            //ULR = User Limit Reached
            model.addAttribute("ULR", "User limit reached!");
            logger.warning("REGISTER FAILED!");
            return "register";
        }

        logger.info("REGISTER COMPLETE!");
        addUser(user);
        System.out.println(users.get(users.size() -1).toString());
        model.addAttribute("firstname", user.getFname());
        model.addAttribute("lastname", user.getLname());
        activeUser = user;
        model.addAttribute("vacations", activeUser.getVacations());
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

    public boolean passwordsDontMatch(User user) {
        return (!(user.getPasswd().equals(user.getPasswd2())));
    }

    public boolean emailAlreadyUsed(User user) {
        for (User userEmail : users) {
            return userEmail.getEmail().equals(user.getEmail());
        }
        return false;
    }

    public boolean userLimitReached() {
        return users.size() +1 > maxUsers;
    }

    public boolean userToYoung(User user){
        String[] YDM = user.getDob().split("-");
        Date dob = new Date(Integer.parseInt(YDM[0]), Integer.parseInt(YDM[1]), Integer.parseInt(YDM[2]));
        return false;
        //For Testing false
        // (LocalDate.now().getYear() - dob.getYear() < 18);
    }

    public boolean noGenderGiven(User user) {
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
        logger.setLevel(Level.ALL);
        logger.info("USER TRYING TO LOGIN");
        for (User userLogin : users) {
            if (successfulLogin(login, userLogin)) {
                model.addAttribute("firstname", userLogin.getFname());
                model.addAttribute("lastname", userLogin.getLname());
                activeUser = userLogin;
                logger.info("LOGIN COMPLETE");
                model.addAttribute("vacations", activeUser.getVacations());
                return "welcome";
            }
        }
        //NSA = No Such Account
        model.addAttribute("NSA", "No such account!");
        logger.warning("LOGIN FAILED");
        return "login";
    }

    public boolean successfulLogin(LoginData login, User userLogin) {
        return userLogin.getEmail().equals(login.getLogEmail()) && userLogin.getPasswd().equals(login.getLogPasswd());
    }

    @RequestMapping("/login")
    public String userLogin() {
        return "login";
    }

    @RequestMapping("/deleteAccount")
    public String deleteAccount(String passwd, Model model) {
        logger.setLevel(Level.ALL);
        logger.info("USER TRYING TO DELETE ACCOUNT");
        System.out.println(activeUser);
        if (passwd.equals(activeUser.getPasswd())) {
            users.remove(activeUser);
            model.addAttribute("DS", "Account deleted successfully");
            logger.info("ACCOUNT DELETED");
            return "register";
        }
        model.addAttribute("firstname", activeUser.getFname());
        model.addAttribute("lastname", activeUser.getLname());
        model.addAttribute("DF", "Check password!");
        logger.warning("DELETION FAILED");
        model.addAttribute("vacations", activeUser.getVacations());
        return "welcome";
    }

    @RequestMapping("/index")
    public String navigateToIndex() {
        return "index";
    }

    @RequestMapping("/addVacation")
    public String addVacation(String start, String end, Model model) throws IOException {
        Vacation vacation = vacationFormat(start, end);
        if (vacation.vacationInputImpossible()){
            System.out.println("Vacation impossible!");
        } else {
            activeUser.addVacation(vacation);
        }
        model.addAttribute("vacations", activeUser.getVacations());
        return "welcome";
    }

    public Vacation vacationFormat(String start, String end) {
        String[] sd = start.split("-");
        LocalDate startDate = LocalDate.of(Integer.parseInt(sd[0]), Integer.parseInt(sd[1]), Integer.parseInt(sd[2]));
        String[] ed = end.split("-");
        LocalDate endDate = LocalDate.of(Integer.parseInt(ed[0]), Integer.parseInt(ed[1]), Integer.parseInt(ed[2]));
        return new Vacation(startDate, endDate);
    }
}
