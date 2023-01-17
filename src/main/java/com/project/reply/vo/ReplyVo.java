package com.project.reply.vo;

public class ReplyVo {
   private int r_idx;
   private String cont;
   private String indate;
   private int b_idx;
   private String u_id;
   private int g_idx;
   private String img;
   private int c_idx;

   public ReplyVo(){}

    public ReplyVo(int r_idx, String cont, String indate, int b_idx, String u_id, int g_idx, String img, int c_idx) {
        this.r_idx = r_idx;
        this.cont = cont;
        this.indate = indate;
        this.b_idx = b_idx;
        this.u_id = u_id;
        this.g_idx = g_idx;
        this.img = img;
        this.c_idx = c_idx;
    }

    public int getC_idx() {
        return c_idx;
    }

    public void setC_idx(int c_idx) {
        this.c_idx = c_idx;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public int getG_idx() {
        return g_idx;
    }

    public void setG_idx(int g_idx) {
        this.g_idx = g_idx;
    }

    @Override
    public String toString() {
        return "ReplyVo{" +
                "r_idx=" + r_idx +
                ", cont='" + cont + '\'' +
                ", indate='" + indate + '\'' +
                ", b_idx=" + b_idx +
                ", u_id='" + u_id + '\'' +
                ", g_idx=" + g_idx +
                ", img='" + img + '\'' +
                ", c_idx=" + c_idx +
                '}';
    }
}


