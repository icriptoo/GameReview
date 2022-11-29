package com.project.board.vo;

public class RiderBoardVo {
    private int board_number;
    private String menu_id;
    private String title;
    private String writer;
    private String rider_local;
    private String cont;
    private String indate;
    private String board_check;
    private String r_start;
    private String r_end;
    private String money;
    private String r_time;
    private String luggage;
    private String delivery_indate;

    public RiderBoardVo() {
    }

    public RiderBoardVo(int board_number, String menu_id, String title, String writer, String rider_local, String cont, String indate, String board_check, String r_start, String r_end, String money, String r_time, String luggage, String delivery_indate) {
        this.board_number = board_number;
        this.menu_id = menu_id;
        this.title = title;
        this.writer = writer;
        this.rider_local = rider_local;
        this.cont = cont;
        this.indate = indate;
        this.board_check = board_check;
        this.r_start = r_start;
        this.r_end = r_end;
        this.money = money;
        this.r_time = r_time;
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

    public String getRider_local() {
        return rider_local;
    }

    public void setRider_local(String rider_local) {
        this.rider_local = rider_local;
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

    public String getR_start() {
        return r_start;
    }

    public void setR_start(String r_start) {
        this.r_start = r_start;
    }

    public String getR_end() {
        return r_end;
    }

    public void setR_end(String r_end) {
        this.r_end = r_end;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getR_time() {
        return r_time;
    }

    public void setR_time(String r_time) {
        this.r_time = r_time;
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
        return "RiderBoardVo{" +
                "board_number=" + board_number +
                ", menu_id='" + menu_id + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", rider_local='" + rider_local + '\'' +
                ", cont='" + cont + '\'' +
                ", indate='" + indate + '\'' +
                ", board_check='" + board_check + '\'' +
                ", r_start='" + r_start + '\'' +
                ", r_end='" + r_end + '\'' +
                ", money='" + money + '\'' +
                ", r_time='" + r_time + '\'' +
                ", luggage='" + luggage + '\'' +
                ", delivery_indate='" + delivery_indate + '\'' +
                '}';
    }
}
