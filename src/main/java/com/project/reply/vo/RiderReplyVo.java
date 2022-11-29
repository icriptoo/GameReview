package com.project.reply.vo;

public class RiderReplyVo {

    private int reply_number;
    private int board_number;
    private String cont;
    private String writer;
    private String indate;

    public RiderReplyVo() {
    }

    public RiderReplyVo(int reply_number, int board_number, String cont, String writer, String indate) {
        this.reply_number = reply_number;
        this.board_number = board_number;
        this.cont = cont;
        this.writer = writer;
        this.indate = indate;
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
        return "RiderReplyVo{" +
                "reply_number=" + reply_number +
                ", board_number=" + board_number +
                ", cont='" + cont + '\'' +
                ", writer='" + writer + '\'' +
                ", indate='" + indate + '\'' +
                '}';
    }
}
