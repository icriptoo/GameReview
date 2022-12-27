package com.project.board.vo;

public class BoardVo {

    private int b_idx;
    private String title;
    private String cont;
    private int r_score;
    private String indate;
    private int b_count;
    private int menu_id;
    private String u_id;
    private int g_idx;

    private String g_name;

    public BoardVo(){};
    public BoardVo(int b_idx, String title, String cont, int r_score, String indate, int b_count, int menu_id, String u_id, int g_idx, String g_name) {
        this.b_idx = b_idx;
        this.title = title;
        this.cont = cont;
        this.r_score = r_score;
        this.indate = indate;
        this.b_count = b_count;
        this.menu_id = menu_id;
        this.u_id = u_id;
        this.g_idx = g_idx;
        this.g_name = g_name;
    }

    public int getB_idx() {
        return b_idx;
    }

    public void setB_idx(int b_idx) {
        this.b_idx = b_idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public int getR_score() {
        return r_score;
    }

    public void setR_score(int r_score) {
        this.r_score = r_score;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public int getB_count() {
        return b_count;
    }

    public void setB_count(int b_count) {
        this.b_count = b_count;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

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

    @Override
    public String toString() {
        return "BoardVo{" +
                "b_idx=" + b_idx +
                ", title='" + title + '\'' +
                ", cont='" + cont + '\'' +
                ", r_score=" + r_score +
                ", indate='" + indate + '\'' +
                ", b_count=" + b_count +
                ", menu_id=" + menu_id +
                ", u_id='" + u_id + '\'' +
                ", g_idx=" + g_idx +
                ", g_name='" + g_name + '\'' +
                '}';
    }
}