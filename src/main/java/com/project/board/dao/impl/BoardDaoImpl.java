package com.project.board.dao.impl;

import com.project.board.dao.BoardDao;
import com.project.board.vo.BoardVo;
import com.project.board.vo.ReviewVo;
import com.project.board.vo.RiderBoardVo;
import com.project.reply.vo.ReplyVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

    @Autowired
    private SqlSession sqlSession;


    @Override
    public void C_insertboard(BoardVo boardVo) {
        this.sqlSession.insert("Board.C_InsertBoard", boardVo);
    }

    @Override
    public void R_insertboard(RiderBoardVo riderboardVo) {
        this.sqlSession.insert("Board.R_InsertBoard", riderboardVo);
    }

    @Override
    public void RV_insertboard(ReviewVo reviewVo) {
        this.sqlSession.insert("Board.RV_InsertBoard", reviewVo);

    }

    @Override
    public BoardVo DetailCustomer(HashMap<String, Object> map) {
        BoardVo boardVo = this.sqlSession.selectOne("Board.DetailCustomerBoard", map);
        return boardVo;
    }

    @Override
    public RiderBoardVo DetailRider(HashMap<String, Object> map) {
        RiderBoardVo riderBoardVo = this.sqlSession.selectOne("Board.DetailRiderBoard",map);
        return riderBoardVo;
    }

    @Override
    public ReviewVo DetailReview(HashMap<String, Object> map) {
        ReviewVo reviewVo = this.sqlSession.selectOne("Board.DetailReviewBoard", map);
        return reviewVo;
    }

    @Override
    public void CBoardUpdate(HashMap<String, Object> map) {
        this.sqlSession.update("Board.CBoardUpdate", map);
    }

    @Override
    public void RBoardUpdate(HashMap<String, Object> map) {
        this.sqlSession.update("Board.RBoardUpdate", map);
    }

    @Override
    public void RVBoardUpdate(HashMap<String, Object> map) {
        this.sqlSession.update("Board.RVBoardUpdate", map);
    }

    @Override
    public void CBoardDelete(HashMap<String, Object> map) {
        this.sqlSession.delete("Board.CBoardDelete", map);
    }

    @Override
    public void RBoardDelete(HashMap<String, Object> map) {
        this.sqlSession.delete("Board.RBoardDelete", map);
    }

    @Override
    public void RVBoardDelete(HashMap<String, Object> map) {
        this.sqlSession.delete("Board.RVBoardDelete", map);
    }

    @Override
    public List<BoardVo> customerList(HashMap<String, Object> map) {
        List<BoardVo> boardList = this.sqlSession.selectList("Board.CustomerList",map);
        return boardList;
    }

    @Override
    public List<BoardVo> CSList(HashMap<String, Object> map) {
        List<BoardVo> boardList = this.sqlSession.selectList("Board.CSList",map);
        return boardList;
    }

    @Override
    public List<BoardVo> reviewList(HashMap<String, Object> map) {
        List<BoardVo> boardList = this.sqlSession.selectList("Board.ReviewList",map);
        return boardList;
    }    @Override
    public List<RiderBoardVo> riderList(HashMap<String, Object> map) {
        List<RiderBoardVo> boardList = this.sqlSession.selectList("Board.RiderList",map);
        return boardList;
    }

    @Override
    public int customerCount() {
        return this.sqlSession.selectOne("Board.CustomerCount");
    }
   @Override
    public int reviewCount() {
        return this.sqlSession.selectOne("Board.ReviewCount");
    }
    @Override
    public int riderCount() {
        return this.sqlSession.selectOne("Board.RiderCount");
    }

    @Override
    public int testCount() {
        return this.sqlSession.selectOne("Board.BoardCount");
    }

    @Override
    public List<BoardVo> testList(HashMap<String, Object> map) {
        List<BoardVo> boardList = this.sqlSession.selectList("Board.BoardPaging",map);
        return boardList;
    }

    @Override
    public List<ReplyVo> replyList(HashMap<String, Object> map) {
        List<ReplyVo> replyList = this.sqlSession.selectList("Reply.ReplyPaging",map);
        return replyList;
    }

    @Override
    public int replyCount(HashMap<String, Object> map) { return this.sqlSession.selectOne("Reply.ReplyCount",map) ; }

    @Override
    public void CBoardCheck(HashMap<String, Object> map) {
        this.sqlSession.update("Board.Check", map);

    }

    @Override
    public void RBoardCheck(HashMap<String, Object> map) {
        this.sqlSession.update("Board.RCheck", map);
    }

    @Override
    public List<BoardVo> myWritePage(String nickname) {
        List<BoardVo> myWritePage = this.sqlSession.selectList("Board.myWritePage", nickname);

        return myWritePage;
    }

    @Override
    public List<RiderBoardVo> myRWritePage(String nickname) {
        List<RiderBoardVo> myRwritePage = this.sqlSession.selectList("Board.myRWritePage", nickname);
        return myRwritePage;
    }

    @Override
    public List<ReviewVo> myRVwritePage(String nickname) {
        List<ReviewVo> myRVwritePage = this.sqlSession.selectList("Board.myRVwritePage", nickname);
        return myRVwritePage;
    }

    @Override
    public int CSCount(HashMap<String, Object> map) {
        return this.sqlSession.selectOne("Board.CSCount", map);
    }

    @Override
    public List<RiderBoardVo> RSList(HashMap<String, Object> map) {
        List<RiderBoardVo> boardList = this.sqlSession.selectList("Board.RSList",map);
        return boardList;
    }

    @Override
    public int RSCount(HashMap<String, Object> map) {
        return this.sqlSession.selectOne("Board.RSCount", map);
    }

    @Override
    public List<BoardVo> RVSList(HashMap<String, Object> map) {
        List<BoardVo> boardList = this.sqlSession.selectList("Board.RVSList",map);
        return boardList;
    }

    @Override
    public int RVSCount(HashMap<String, Object> map) {
        return this.sqlSession.selectOne("Board.RVSCount",map);
    }


}
