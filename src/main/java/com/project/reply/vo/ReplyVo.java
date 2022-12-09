package com.project.reply.vo;

public class ReplyVo {
   private int r_idx;
   private String cont;
   private String indate;
   private int b_idx;
   private String u_id;

   public ReplyVo(){}

   public ReplyVo(int r_idx, String cont, String indate, int b_idx, String u_id) {
        this.r_idx = r_idx;
        this.cont = cont;
        this.indate = indate;
        this.b_idx = b_idx;
        this.u_id = u_id;
    }

    public int getR_idx() {
        return r_idx;
    }

    public void setR_idx(int r_idx) {
        this.r_idx = r_idx;
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

    public int getB_idx() {
        return b_idx;
    }

    public void setB_idx(int b_idx) {
        this.b_idx = b_idx;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "ReplyVo{" +
                "r_idx=" + r_idx +
                ", cont='" + cont + '\'' +
                ", indate='" + indate + '\'' +
                ", b_idx=" + b_idx +
                ", u_id='" + u_id + '\'' +
                '}';
    }
}


