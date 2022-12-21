package com.project.user.vo;

public class EmailCodeCheck {
    private String ecode;

    private EmailCodeCheck(){}
    public EmailCodeCheck(String ecode) {
        this.ecode = ecode;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    @Override
    public String toString() {
        return "EmailCodeCheck{" +
                "ecode='" + ecode + '\'' +
                '}';
    }
}
