package com.project.board.vo;

public class ReplyPager {

    private int reply_number;
    private int board_number;
    private String cont;
    private String writer;
    private String indate;
    private String menu_id;
    private int rend_page;

    public ReplyPager(){}

    public ReplyPager(int reply_number, int board_number, String cont, String writer, String indate, String menu_id, int rend_page) {
        this.reply_number = reply_number;
        this.board_number = board_number;
        this.cont = cont;
        this.writer = writer;
        this.indate = indate;
        this.menu_id = menu_id;
        this.rend_page = rend_page;
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

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    private int totalCount;   // 댓글 총 개수
    private int pageNum;      // 현재 페이지 번호
    private int contentNum;   // 한 페이지에 보여줄 댓글 개수
    private int startPage=1;  // 현재 페이지 블록 시작 번호
    private int endPage=5;    // 현재 페이지 블록 종료 번호
    private boolean prev;     // 이전 페이지로 가는 화살표
    private boolean next;     // 다음 페이지로 가는 화살표
    private int currentBlock; // 현재 페이지 블럭
    private double lastBlock; // 마지막 페이지 블럭


    public void prevNext(int pageNum1){ // 이전, 다음 페이지 블록
        if(totalCount<=50){
            setPrev(false);
            setNext(false);
        }else if ( lastBlock >= 2.0 && currentBlock < lastBlock ){
            setPrev(false);
            setNext(true);
        }else if ( lastBlock > 1.0 && currentBlock > 1.0){
            setPrev(true);
            setNext(false);
        }else {
            setPrev(true);
            setNext(true);
        }
    }
    public int calcPage(int totalCount){ // 전체페이지 개수를 계산하는 함수
        //    12.5    =     125    /     10
        //   13페이지
        int totalPage = totalCount / 10;
        return totalPage;
    }

    public int getRend_page() {
        return rend_page;
    }

    public void setRend_page() {
        this.rend_page = rend_page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getContentNum() {
        return contentNum;
    }

    public void setContentNum(int contentNum) {
        this.contentNum = contentNum;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int getCurrentBlock() {
        return currentBlock;
    }

    public void setCurrentBlock(int pageNum) {
        // 현제페이지 블록 구하는 곳, 페이지 번호를 통해 구한다
        // 페이지 번호 / 페이지 그룹안의 페이지 개수
        this.currentBlock = pageNum/5;
        if(pageNum%5 > 0) {
            this.currentBlock++;
        }
    }
    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = (currentBlock * 5) - 4;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage() { // 마지막 페이지 블록 구하는 곳
        if (lastBlock == currentBlock){
            endPage = totalCount / 10;
            if (0< (totalCount % 10)){
                endPage++;
            }
        }else {
            endPage = getStartPage() + 4;
        }
    }

    public double getLastBlock() {
        return lastBlock;
    }

    public void setLastBlock() {
        lastBlock = totalCount / 50;
        if (totalCount % (5 * contentNum) > 0){
            lastBlock++;
        }
    }

    @Override
    public String toString() {
        return "ReplyPager{" +
                "reply_number=" + reply_number +
                ", board_number=" + board_number +
                ", cont='" + cont + '\'' +
                ", writer='" + writer + '\'' +
                ", indate='" + indate + '\'' +
                ", menu_id='" + menu_id + '\'' +
                ", totalCount=" + totalCount +
                ", pageNum=" + pageNum +
                ", contentNum=" + contentNum +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                ", currentBlock=" + currentBlock +
                ", lastBlock=" + lastBlock +
                ", rend_page=" + rend_page +
                '}';
    }
}
