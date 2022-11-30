package com.project.reply.vo;

public class ReplyVo {

    private int reply_number;
    private int board_number;
    private String cont;
    private String writer;
    private String indate;
    private String menu_id;
    private int pagNum;
    private int contentNum;


    public ReplyVo() {
    }

    public ReplyVo(int board_number, int pagNum, int contentNum, String menu_id) {
        this.board_number = board_number;
        this.pagNum = pagNum;
        this.contentNum = contentNum;
        this.menu_id = menu_id;
    }

    public ReplyVo(int reply_number, int board_number, String cont, String writer, String indate, int pagNum, int contentNum) {
        this.reply_number = reply_number;
        this.board_number = board_number;
        this.cont = cont;
        this.writer = writer;
        this.indate = indate;
        this.pagNum = pagNum;
        this.contentNum = contentNum;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public int getPagNum() {
        return pagNum;
    }

    public void setPagNum(int pagNum) {
        this.pagNum = pagNum;
    }

    public int getContentNum() {
        return contentNum;
    }

    public void setContentNum(int contentNum) {
        this.contentNum = contentNum;
    }

    public int getReply_number() {
        return reply_number;
    }

    public void setReply_number(int reply_number) {
        this.reply_number = reply_number;
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

    @Override
    public String toString() {
        return "ReplyVo{" +
                "reply_number=" + reply_number +
                ", board_number=" + board_number +
                ", cont='" + cont + '\'' +
                ", writer='" + writer + '\'' +
                ", indate='" + indate + '\'' +
                ", pagNum=" + pagNum +
                ", contentNum=" + contentNum +
                '}';
    }
}


