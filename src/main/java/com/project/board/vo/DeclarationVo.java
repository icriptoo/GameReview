package com.project.board.vo;

public class DeclarationVo {

    private int d_idx;
    private String cont;
    private String indate;
    private String us_id;
    private String ue_id;
    private int b_idx;
    private int type_idx;
    private int process;
    private String us_name;
    private String ue_name;

    public DeclarationVo(){};
    public DeclarationVo(int d_idx, String cont, String indate, String us_id, String ue_id, int b_idx, int type_idx, String us_name, String ue_name, int process) {
        this.d_idx = d_idx;
        this.cont = cont;
        this.indate = indate;
        this.us_id = us_id;
        this.ue_id = ue_id;
        this.b_idx = b_idx;
        this.type_idx = type_idx;
        this.us_name = us_name;
        this.ue_name = ue_name;
        this.process = process;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public String getUs_name() {
        return us_name;
    }

    public void setUs_name(String us_name) {
        this.us_name = us_name;
    }

    public String getUe_name() {
        return ue_name;
    }

    public void setUe_name(String ue_name) {
        this.ue_name = ue_name;
    }

    public int getD_idx() {
        return d_idx;
    }

    public void setD_idx(int d_idx) {
        this.d_idx = d_idx;
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

    public String getUs_id() {
        return us_id;
    }

    public void setUs_id(String us_id) {
        this.us_id = us_id;
    }

    public String getUe_id() {
        return ue_id;
    }

    public void setUe_id(String ue_id) {
        this.ue_id = ue_id;
    }

    public int getB_idx() {
        return b_idx;
    }

    public void setB_idx(int b_idx) {
        this.b_idx = b_idx;
    }

    public int getType_idx() {
        return type_idx;
    }

    public void setType_idx(int type_idx) {
        this.type_idx = type_idx;
    }

    @Override
    public String toString() {
        return "DeclarationVo{" +
                "d_idx=" + d_idx +
                ", cont='" + cont + '\'' +
                ", indate='" + indate + '\'' +
                ", us_id='" + us_id + '\'' +
                ", ue_id='" + ue_id + '\'' +
                ", b_idx=" + b_idx +
                ", type_idx=" + type_idx +
                ", process=" + process +
                ", us_name='" + us_name + '\'' +
                ", ue_name='" + ue_name + '\'' +
                '}';
    }
}