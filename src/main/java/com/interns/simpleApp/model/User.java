package com.interns.simpleApp.model;

public class User {
    private String fname;
    private String lname;
    private String email;
    private String passwd;
    private String passwd2;
    private String dob;
    private String gender;

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
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPasswd2() {
        return passwd2;
    }
    public void setPasswd2(String passwd2) {
        this.passwd2 = passwd2;
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
