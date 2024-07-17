package com.interns.simpleApp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class User {
    private String fname;
    private String lname;
    private String email;
    private String passwd;
    private String passwd2;
    private String dob;
    private String gender;
    private List<Vacation> vacations = new ArrayList<>();

    public User(String fname, String lname, String email, String passwd, String passwd2, String dob, String gender) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.passwd = passwd;
        this.passwd2 = passwd2;
        this.dob = dob;
        this.gender = gender;
    }

    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public String getEmail() {
        return email;
    }
    public String getPasswd() {
        return passwd;
    }
    public String getDob() {
        return dob;
    }
    public String getGender() {
        return gender;
    }
    public String getPasswd2() {
        return passwd2;
    }

    public void addVacation(String start, String end) {
        String[] sd = start.split("-");
        LocalDate startDate = LocalDate.of(Integer.parseInt(sd[0]), Integer.parseInt(sd[1]), Integer.parseInt(sd[2]));
        String[] ed = end.split("-");
        LocalDate endDate = LocalDate.of(Integer.parseInt(ed[0]), Integer.parseInt(ed[1]), Integer.parseInt(ed[2]));
        vacations.add(new Vacation(startDate, endDate));
    }

    public void printVacations() {
        if (vacations.size() == 0){
            System.out.println("no vacations");
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            for (Vacation vacation : vacations){
                System.out.println("Start: " + vacation.getStartDate().format(formatter)
                        + "| End: " + vacation.getEndDate().format(formatter)
                        + "| Duration in Days: " + vacation.durationInDays(vacation));
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
