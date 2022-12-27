package com.project.board.vo;

public class GameSelectVo {
    String g_company;

    public GameSelectVo(){}
    public GameSelectVo(String g_company) {
        this.g_company = g_company;
    }

    public String getG_company() {
        return g_company;
    }

    public void setG_company(String g_company) {
        this.g_company = g_company;
    }

    @Override
    public String toString() {
        return "GameSelectVo{" +
                "g_company='" + g_company + '\'' +
                '}';
    }
}
