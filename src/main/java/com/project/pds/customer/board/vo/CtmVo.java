package com.project.pds.customer.board.vo;

public class CtmVo {
    private String file_num;
    private String customer_board_number;
    private String fileName;
    private String fileExit;
    private String sFileName;

    public CtmVo() {
    }

    public CtmVo(String file_num, String customer_board_number, String fileName, String fileExit, String sFileName) {
        this.file_num = file_num;
        this.customer_board_number = customer_board_number;
        this.fileName = fileName;
        this.fileExit = fileExit;
        this.sFileName = sFileName;
    }

    public CtmVo(String customer_board_number, String fileName, String fileExit, String sFileName) {
        this.customer_board_number = customer_board_number;
        this.fileName = fileName;
        this.fileExit = fileExit;
        this.sFileName = sFileName;
    }

    public String getFile_num() {
        return this.file_num;
    }

    public void setFile_num(String file_num) {
        this.file_num = file_num;
    }

    public String getCustomer_board_number() {
        return this.customer_board_number;
    }

    public void setCustomer_board_number(String customer_board_number) {
        this.customer_board_number = customer_board_number;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExit() {
        return this.fileExit;
    }

    public void setFileExit(String fileExit) {
        this.fileExit = fileExit;
    }

    public String getsFileName() {
        return this.sFileName;
    }

    public void setsFileName(String sFileName) {
        this.sFileName = sFileName;
    }

    @Override
    public String toString() {
        return "CtmVo{" +
                "file_num='" + this.file_num + '\'' +
                ", customer_board_number='" + this.customer_board_number + '\'' +
                ", fileName='" + this.fileName + '\'' +
                ", fileExit='" + this.fileExit + '\'' +
                ", sFileName='" + this.sFileName + '\'' +
                '}';
    }
}
