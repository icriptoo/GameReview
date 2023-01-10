package com.project.user.vo;

public class UserVo {

    private String u_id;
    private String n_name;
    private String pw;
    private String email;
    private String genre1;
    private String genre2;
    private String genre3;
    private String img;
    private String indate;
    private String pcode; // 비밀번호salt
    private String withdrawal; // 회원정보 on/off 기능 탈퇴하면 off
    private String authority; // 관리자 구분자 0=관리자 1=일반회원

    public UserVo (){}

    public UserVo(String u_id, String n_name, String pw, String email, String genre1, String genre2, String genre3, String img, String indate, String pcode, String withdrawal, String authority) {
        this.u_id = u_id;
        this.n_name = n_name;
        this.pw = pw;
        this.email = email;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.genre3 = genre3;
        this.img = img;
        this.indate = indate;
        this.pcode = pcode;
        this.withdrawal = withdrawal;
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(String withdrawal) {
        this.withdrawal = withdrawal;
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

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
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
                ", img='" + img + '\'' +
                ", indate='" + indate + '\'' +
                ", pcode='" + pcode + '\'' +
                ", withdrawal='" + withdrawal + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
