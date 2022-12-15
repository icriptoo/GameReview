package com.project.user.vo;

public class FilesVo {
    private String u_id;
    private String fileName;
    private String fileExit;
    private String sFileName;

    public FilesVo(){}
    public FilesVo(String u_id, String fileName, String fileExit, String sFileName) {
        this.u_id = u_id;
        this.fileName = fileName;
        this.fileExit = fileExit;
        this.sFileName = sFileName;
    }
    public String getUserid() {
        return u_id;
    }

    public void setUserid(String u_id) {
        this.u_id = u_id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExit() {
        return fileExit;
    }

    public void setFileExit(String fileExit) {
        this.fileExit = fileExit;
    }

    public String getsFileName() {
        return sFileName;
    }

    public void setsFileName(String sFileName) {
        this.sFileName = sFileName;
    }

    @Override
    public String toString() {
        return "FilesVo{" +
                " u_id='" + u_id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileExit='" + fileExit + '\'' +
                ", sFileName='" + sFileName + '\'' +
                '}';
    }
}
