package com.project.reply.vo;

public class CReplyVo {
    private int board_number;
    private String cont;
    private String writer;
    private String indate;
    private String title;
    private String menu_id;

    public CReplyVo() {
    }

    public CReplyVo(int board_number, String cont, String writer, String indate, String title, String menu_id) {
        this.board_number = board_number;
        this.cont = cont;
        this.writer = writer;
        this.indate = indate;
        this.title = title;
        this.menu_id = menu_id;
    }

    public int getBoard_number() {
        return board_number;
    }

    public void setBoard_number(int board_number) {
        this.board_number = board_number;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    @Override
    public String toString() {
        return "CReplyVo{" +
                "board_number=" + board_number +
                ", cont='" + cont + '\'' +
                ", writer='" + writer + '\'' +
                ", indate='" + indate + '\'' +
                ", title='" + title + '\'' +
                ", menu_id='" + menu_id + '\'' +
                '}';
    }
}
