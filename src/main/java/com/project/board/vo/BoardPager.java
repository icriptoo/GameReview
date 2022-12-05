package com.project.board.vo;

public class BoardPager {

    private int totalCount;   // 게시글 총 개수
    private int pageNum;      // 현재 페이지 번호
    private int contentNum;   // 한 페이지에 보여줄 게시글 개수
    private int startPage=1;  // 현재 페이지 블록 시작 번호
    private int endPage=5;    // 현재 페이지 블록 종료 번호
    private boolean prev;     // 이전 페이지로 가는 화살표
    private boolean next;     // 다음 페이지로 가는 화살표
    private int currentBlock; // 다음 페이지로 가는 화살표
    private double lastBlock;    // 다음 페이지로 가는 화살표
    private int lastPageNum;
    public void prevNext(int pageNum){ // 이전, 다음 페이지 블록
        if(calcPage(totalCount)<11){
            setPrev(false);
            setNext(false);
        }else if (pageNum>0 && pageNum<=10){
            setPrev(false);
            setNext(true);
        }else if (lastBlock == currentBlock){
            setPrev(true);
            setNext(false);
        }else {
            setPrev(true);
            setNext(true);
        }
    }

    public double calcPage(int totalCount){ // 전체페이지 개수를 계산하는 함수
        //    12.5    =     125    /     10
        //   13페이지
        int toP = totalCount /30;
        double totalPage = (double) totalCount / 30;
        if (toP < totalPage) {
            totalPage += 1;
        }
        lastPageNum = (int) totalPage;
        return totalPage;
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

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage() {
        this.startPage = (currentBlock * 10) - 9;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage() { // 마지막 페이지 블록 구하는 곳
        if (lastBlock == currentBlock){
            endPage = totalCount / 30;
            if (0< (totalCount % 30)){
                endPage++;
            }
        }else {
            endPage = getStartPage() + 9;
        }
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
        this.currentBlock = pageNum/10;
        if(pageNum%10 > 0) {
            this.currentBlock++;
        }
    }

    public double getLastBlock() {
        return lastBlock;
    }

    public void setLastBlock() {
        lastBlock = totalCount / 300;
        if ((totalCount % 300) > 0){
            lastBlock++;
        }
    }

    public int getLastPageNum() {
        return lastPageNum;
    }

    @Override
    public String toString() {
        return "BoardPager{" +
                "totalCount=" + totalCount +
                ", pageNum=" + pageNum +
                ", contentNum=" + contentNum +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                ", currentBlock=" + currentBlock +
                ", lastBlock=" + lastBlock +
                ", lastPageNum=" + lastPageNum +
                '}';
    }
}