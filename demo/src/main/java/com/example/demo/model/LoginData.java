package com.example.demo.model;

public class LoginData {
    private String logEmail;
    private String logPasswd;

    public LoginData(String logEmail, String logPasswd) {
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
