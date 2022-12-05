package com.project.board.vo;

public class GameListVo {

    private int g_idx;
    private String g_name;
    private String g_ename;
    private String g_genre;
    private String g_company;
    private String g_service;
    private String g_platform;
    private String g_date;
    private String g_score;
    private String g_img;

    public GameListVo(int g_idx, String g_name, String g_ename, String g_genre, String g_company, String g_service, String g_platform, String g_date, String g_score, String g_img) {
        this.g_idx = g_idx;
        this.g_name = g_name;
        this.g_ename = g_ename;
        this.g_genre = g_genre;
        this.g_company = g_company;
        this.g_service = g_service;
        this.g_platform = g_platform;
        this.g_date = g_date;
        this.g_score = g_score;
        this.g_img = g_img;
    }

    public GameListVo(){}

    public int getG_idx() {
        return g_idx;
    }

    public void setG_idx(int g_idx) {
        this.g_idx = g_idx;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_ename() {
        return g_ename;
    }

    public void setG_ename(String g_ename) {
        this.g_ename = g_ename;
    }

    public String getG_genre() {
        return g_genre;
    }

    public void setG_genre(String g_genre) {
        this.g_genre = g_genre;
    }

    public String getG_company() {
        return g_company;
    }

    public void setG_company(String g_company) {
        this.g_company = g_company;
    }

    public String getG_service() {
        return g_service;
    }

    public void setG_service(String g_service) {
        this.g_service = g_service;
    }

    public String getG_platform() {
        return g_platform;
    }

    public void setG_platform(String g_platform) {
        this.g_platform = g_platform;
    }

    public String getG_date() {
        return g_date;
    }

    public void setG_date(String g_date) {
        this.g_date = g_date;
    }

    public String getG_score() {
        return g_score;
    }

    public void setG_score(String g_score) {
        this.g_score = g_score;
    }

    public String getG_img() {
        return g_img;
    }

    public void setG_img(String g_img) {
        this.g_img = g_img;
    }

    @Override
    public String toString() {
        return "GameListVo{" +
                "g_idx=" + g_idx +
                ", g_name='" + g_name + '\'' +
                ", g_ename='" + g_ename + '\'' +
                ", g_genre='" + g_genre + '\'' +
                ", g_company='" + g_company + '\'' +
                ", g_service='" + g_service + '\'' +
                ", g_platform='" + g_platform + '\'' +
                ", g_date='" + g_date + '\'' +
                ", g_score='" + g_score + '\'' +
                ", g_img='" + g_img + '\'' +
                '}';
    }
}
