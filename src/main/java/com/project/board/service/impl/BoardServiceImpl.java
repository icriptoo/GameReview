package com.project.board.service.impl;

import com.project.board.dao.BoardDao;
import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import com.project.board.vo.GameListVo;
import com.project.board.vo.ReviewVo;
import com.project.board.vo.RiderBoardVo;
import com.project.reply.vo.ReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDao boardDao;



    @Override
    public void C_insertboard(BoardVo boardVo) {
        this.boardDao.C_insertboard(boardVo);
    }

    @Override
    public void R_insertboard(RiderBoardVo riderboardVo) {
        this.boardDao.R_insertboard(riderboardVo);
    }

    @Override
    public void RV_insertboard(ReviewVo reviewVo) {
        this.boardDao.RV_insertboard(reviewVo);
    }


    @Override
    public BoardVo DetailCustomer(HashMap<String, Object> map) {
        BoardVo boardVo = this.boardDao.DetailCustomer(map);
        return boardVo;
    }

    @Override
    public RiderBoardVo DetailRider(HashMap<String, Object> map) {
        RiderBoardVo riderBoardVo = this.boardDao.DetailRider(map);
        return riderBoardVo;
    }

    @Override
    public ReviewVo DetailReview(HashMap<String, Object> map) {
        ReviewVo reviewVo = this.boardDao.DetailReview(map);
        return reviewVo;
    }

    @Override
    public void CBoardUpdate(HashMap<String, Object> map) {
        this.boardDao.CBoardUpdate(map);

    }

    @Override
    public void RBoardUpdate(HashMap<String, Object> map) {
        this.boardDao.RBoardUpdate(map);
    }

    @Override
    public void RVBoardUpdate(HashMap<String, Object> map) {
        this.boardDao.RVBoardUpdate(map);
    }

    @Override
    public void CBOardDelete(HashMap<String, Object> map) {
        this.boardDao.CBoardDelete(map);
    }

    @Override
    public void RBoardDelete(HashMap<String, Object> map) {
        this.boardDao.RBoardDelete(map);
    }

    @Override
    public void RVBoardDelete(HashMap<String, Object> map) {
        this.boardDao.RVBoardDelete(map);

    }

    @Override
    public int customerCount() {
        return this.boardDao.customerCount();
    }

    @Override
    public int reviewCount() {
        return this.boardDao.reviewCount();
    }
    @Override
    public int riderCount() {
        return this.boardDao.riderCount();
    }

    // 고객게시글 모두 조회
    @Override
    public List<BoardVo> customerList(HashMap<String, Object> map) {
        List<BoardVo> boardList = this.boardDao.customerList(map);
        return boardList;
    }

    // 검색 고객게시글 리스트 조회
    @Override
    public List<BoardVo> CSList(HashMap<String, Object> map) {
        List<BoardVo> boardList = this.boardDao.CSList(map);
        return boardList;
    }

    @Override
    public List<BoardVo> reviewList(HashMap<String, Object> map) {
        List<BoardVo> boardList = this.boardDao.reviewList(map);
        return boardList;
    }
    @Override
    public List<RiderBoardVo> riderList(HashMap<String, Object> map) {
        List <RiderBoardVo> boardList = this.boardDao.riderList(map);
        return boardList;
    }

    @Override
        public int testCount() {
            return this.boardDao.testCount();
        }


    @Override
    public List<BoardVo> testList(HashMap<String, Object> map) {
        List<BoardVo> boardList = this.boardDao.testList(map);
        return boardList;
    }

    @Override
    public List<ReplyVo> replyList(HashMap<String, Object> map) {
        List<ReplyVo> replyList = this.boardDao.replyList(map);
        return replyList;
    }

    @Override
    public int replyCount(HashMap<String, Object> map) { return this.boardDao.replyCount(map); }

    @Override
    public void CBoardCheck(HashMap<String, Object> map) {
        this.boardDao.CBoardCheck(map);
    }

    @Override
    public void RBOardCheck(HashMap<String, Object> map) {
        this.boardDao.RBoardCheck(map);
    }

    @Override
    public List<BoardVo> myWritePage(String nickname) {
        List<BoardVo> myWritePage = this.boardDao.myWritePage(nickname);

        return myWritePage;
    }

    @Override
    public List<RiderBoardVo> myRWritePage(String nickname) {
        List<RiderBoardVo> myRwritePage = this.boardDao.myRWritePage(nickname);

        return myRwritePage;
    }

    @Override
    public List<ReviewVo> myRVwritePage(String nickname) {
        List<ReviewVo> myRVwritePage = this.boardDao.myRVwritePage(nickname);
        return myRVwritePage;
    }

    @Override
    public int CSCount(HashMap<String, Object> map) {
        return this.boardDao.CSCount(map);
    }

    @Override
    public List<RiderBoardVo> RSList(HashMap<String, Object> map) {
        List<RiderBoardVo> boardList = this.boardDao.RSList(map);
        return boardList;
    }

    @Override
    public int RSCount(HashMap<String, Object> map) {
        return this.boardDao.RSCount(map);
    }

    @Override
    public List<BoardVo> RVSList(HashMap<String, Object> map) {
        List<BoardVo> boardList = this.boardDao.RVSList(map);
        return boardList;
    }

    @Override
    public int RVSCount(HashMap<String, Object> map) {
        return this.boardDao.RVSCount(map);
    }

    @Override
    public void GameInsert() throws IOException { boardDao.GameInsert(); }

    @Override
    public int GameListCount() {
        return boardDao.GameListCount();
    }

    @Override
    public List<GameListVo> GameListSelect(HashMap<String, Object> map) {
        List<GameListVo> gameList = boardDao.GameListSelect(map);
        return gameList;
    }


}


