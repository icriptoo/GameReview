package com.project.board.vo;

public class BoardVo {

    private int board_number;
    private String menu_id;
    private String title;
    private String writer;
    private String board_local;
    private String cont;
    private String indate;
    private String board_check;
    private String c_start;
    private String c_end;
    private String money;
    private String c_time;
    private String luggage;

    private String delivery_indate;



    public BoardVo() {}

    public BoardVo(int board_number, String menu_id, String title, String writer, String board_local, String cont, String indate, String board_check, String c_start, String c_end, String money, String c_time, String luggage, String delivery_indate) {        this.board_number = board_number;
        this.menu_id = menu_id;
        this.title = title;
        this.writer = writer;
        this.board_local = board_local;
        this.cont = cont;
        this.indate = indate;
        this.board_check = board_check;
        this.c_start = c_start;
        this.c_end = c_end;
        this.money = money;
        this.c_time = c_time;
        this.luggage = luggage;
        this.delivery_indate = delivery_indate;
    }

    public int getBoard_number() {
        return board_number;
    }

    public void setBoard_number(int board_number) {
        this.board_number = board_number;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getBoard_local() {
        return board_local;
    }

    public void setBoard_local(String board_local) {
        this.board_local = board_local;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getBoard_check() {
        return board_check;
    }

    public void setBoard_check(String board_check) {
        this.board_check = board_check;
    }

    public String getC_start() {
        return c_start;
    }

    public void setC_start(String c_start) {
        this.c_start = c_start;
    }

    public String getC_end() {
        return c_end;
    }

    public void setC_end(String c_end) {
        this.c_end = c_end;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public String getDelivery_indate() {
        return delivery_indate;
    }

    public void setDelivery_indate(String delivery_indate) {
        this.delivery_indate = delivery_indate;
    }

    @Override
    public String toString() {
        return "BoardVo{" +
                "board_number=" + board_number +
                ", menu_id='" + menu_id + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", board_local='" + board_local + '\'' +
                ", cont='" + cont + '\'' +
                ", indate='" + indate + '\'' +
                ", board_check='" + board_check + '\'' +
                ", c_start='" + c_start + '\'' +
                ", c_end='" + c_end + '\'' +
                ", money='" + money + '\'' +
                ", c_time='" + c_time + '\'' +
                ", luggage='" + luggage + '\'' +
                ", delivery_indate='" + delivery_indate + '\'' +
                '}';
    }
}