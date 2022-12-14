package com.project.board.vo;

public class BoardVo {

    private int b_idx;
    private String title;
    private String cont;
    private int r_score;
    private String indate;
    private int B_COUNT;
    private int MENU_ID;
    private String U_ID;
    private int G_IDX;

    public BoardVo(){};
    public BoardVo(int b_idx, String title, String cont, int r_score, String indate, int b_COUNT, int MENU_ID, String u_ID, int g_IDX) {
        this.b_idx = b_idx;
        this.title = title;
        this.cont = cont;
        this.r_score = r_score;
        this.indate = indate;
        B_COUNT = b_COUNT;
        this.MENU_ID = MENU_ID;
        U_ID = u_ID;
        G_IDX = g_IDX;
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

    public int getB_COUNT() {
        return B_COUNT;
    }

    public void setB_COUNT(int b_COUNT) {
        B_COUNT = b_COUNT;
    }

    public int getMENU_ID() {
        return MENU_ID;
    }

    public void setMENU_ID(int MENU_ID) {
        this.MENU_ID = MENU_ID;
    }

    public String getU_ID() {
        return U_ID;
    }

    public void setU_ID(String u_ID) {
        U_ID = u_ID;
    }

    public int getG_IDX() {
        return G_IDX;
    }

    public void setG_IDX(int g_IDX) {
        G_IDX = g_IDX;
    }

    @Override
    public String toString() {
        return "BoardVo{" +
                "b_idx=" + b_idx +
                ", title='" + title + '\'' +
                ", cont='" + cont + '\'' +
                ", r_score=" + r_score +
                ", indate='" + indate + '\'' +
                ", B_COUNT=" + B_COUNT +
                ", MENU_ID=" + MENU_ID +
                ", U_ID='" + U_ID + '\'' +
                ", G_IDX=" + G_IDX +
                '}';
    }
}