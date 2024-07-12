package com.example.demo.model;

public class loginData {
    private String logEmail;
    private String logPasswd;

    public loginData(String logEmail, String logPasswd) {
        this.logEmail = logEmail;
        this.logPasswd = logPasswd;
    }

    public String getLogEmail() {
        return logEmail;
    }
    public void setLogEmail(String logEmail) {
        this.logEmail = logEmail;
    }
    public String getLogPasswd() {
        return logPasswd;
    }
    public void setLogPasswd(String logPasswd) {
        this.logPasswd = logPasswd;
    }
}
