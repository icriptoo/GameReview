package com.project.user.vo;

public class UserVo {

    private String u_id;
    private String n_name;
    private String pw;
    private String email;
    private String genre1;
    private String genre2;
    private String genre3;
    private String p_q;
    private String p_a;
    private String img;
    private String indate;

    public UserVo (String u_id){}

    public UserVo(String u_id, String n_name, String pw, String email, String genre1, String genre2, String genre3, String p_q, String p_a, String img, String indate) {
        this.u_id = u_id;
        this.n_name = n_name;
        this.pw = pw;
        this.email = email;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.genre3 = genre3;
        this.p_q = p_q;
        this.p_a = p_a;
        this.img = img;
        this.indate = indate;
    }

    public String getPw() { return pw; }

    public void setPw(String pw) { this.pw = pw; }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getN_name() {
        return n_name;
    }

    public void setN_name(String n_name) {
        this.n_name = n_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public void setGenre3(String genre3) {
        this.genre3 = genre3;
    }

    public String getP_q() {
        return p_q;
    }

    public void setP_q(String p_q) {
        this.p_q = p_q;
    }

    public String getP_a() {
        return p_a;
    }

    public void setP_a(String p_a) {
        this.p_a = p_a;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "u_id='" + u_id + '\'' +
                ", n_name='" + n_name + '\'' +
                ", pw='" + pw + '\'' +
                ", email='" + email + '\'' +
                ", genre1='" + genre1 + '\'' +
                ", genre2='" + genre2 + '\'' +
                ", genre3='" + genre3 + '\'' +
                ", p_q='" + p_q + '\'' +
                ", p_a='" + p_a + '\'' +
                ", img='" + img + '\'' +
                ", indate='" + indate + '\'' +
                '}';
    }
}
