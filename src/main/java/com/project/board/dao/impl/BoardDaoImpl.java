package com.project.board.dao.impl;

import com.project.board.dao.BoardDao;
import com.project.board.vo.BoardVo;
import com.project.board.vo.ReviewVo;
import com.project.board.vo.RiderBoardVo;
import com.project.reply.vo.ReplyVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    @Override
    public void GameInsert(ArrayList<String> gr) {

        System.out.println(gr.get(0));
        System.out.println(gr.get(1));
        System.out.println(gr.get(2));
        System.out.println(gr.get(3));
        System.out.println(gr.get(4));
        System.out.println(gr.get(5));
        String[] Gtest = gr.get(0).split(":");
        System.out.println(Gtest[0]);
        System.out.println(Gtest[1]);
        //장르
        String te = gr.get(1);
        String te1 = gr.get(7);
        String te2 = gr.get(13);
        String te3 = gr.get(19);
        String te4 = gr.get(25);
        String te5 = gr.get(31);
        String te6 = gr.get(37);
        String te7 = gr.get(43);
        String te8 = gr.get(49);
        String te9 = gr.get(55);
        String te10 = gr.get(61);
        String te11 = gr.get(67);
        String te12 = gr.get(73);
        String te13 = gr.get(79);
        String te14 = gr.get(85);
        String te15 = gr.get(91);
        String te16 = gr.get(97);
        String te17 = gr.get(103);
        String te18 = gr.get(109);
        String te19 = gr.get(115);
        String te20 = gr.get(121);
        String te21 = gr.get(127);
        String te22 = gr.get(133);
        String te23 = gr.get(139);
        String te24 = gr.get(145);
        String te25 = gr.get(151);
        String te26 = gr.get(157);
        String te27 = gr.get(163);
        String te28 = gr.get(169);
        String te29 = gr.get(175);

        String[] tes = te.split(":");
        String[] tes1 = te1.split(":");
        String[] tes2 = te2.split(":");
        String[] tes3 = te3.split(":");
        String[] tes4 = te4.split(":");
        String[] tes5 = te5.split(":");
        String[] tes6 = te6.split(":");
        String[] tes7 = te7.split(":");
        String[] tes8 = te8.split(":");
        String[] tes9 = te9.split(":");
        String[] tes10 = te10.split(":");
        String[] tes11 = te11.split(":");
        String[] tes12 = te12.split(":");
        String[] tes13 = te13.split(":");
        String[] tes14 = te14.split(":");
        String[] tes15 = te15.split(":");
        String[] tes16 = te16.split(":");
        String[] tes17 = te17.split(":");
        String[] tes18 = te18.split(":");
        String[] tes19 = te19.split(":");
        String[] tes20 = te20.split(":");
        String[] tes21 = te21.split(":");
        String[] tes22 = te22.split(":");
        String[] tes23 = te23.split(":");
        String[] tes24 = te24.split(":");
        String[] tes25 = te25.split(":");
        String[] tes26 = te26.split(":");
        String[] tes27 = te27.split(":");
        String[] tes28 = te28.split(":");
        String[] tes29 = te29.split(":");

        String test = tes[1];
        String test1 = tes1[1];
        String test2 = tes2[1];
        String test3 = tes3[1];
        String test4 = tes4[1];
        String test5 = tes5[1];
        String test6 = tes6[1];
        String test7 = tes7[1];
        String test8 = tes8[1];
        String test9 = tes9[1];
        String test10 = tes10[1];
        String test11 = tes11[1];
        String test12 = tes12[1];
        String test13 = tes13[1];
        String test14 = tes14[1];
        String test15 = tes15[1];
        String test16 = tes16[1];
        String test17 = tes17[1];
        String test18 = tes18[1];
        String test19 = tes19[1];
        String test20 = tes20[1];
        String test21 = tes21[1];
        String test22 = tes22[1];
        String test23 = tes23[1];
        String test24 = tes24[1];
        String test25 = tes25[1];
        String test26 = tes26[1];
        String test27 = tes27[1];
        String test28 = tes28[1];
        String test29 = tes29[1];

//        sqlSession.update("Game.Genre",test);
//        sqlSession.update("Game.Genre",test2);
//        sqlSession.update("Game.Genre",test3);
//        sqlSession.update("Game.Genre",test4);
//        sqlSession.update("Game.Genre",test5);
//        sqlSession.update("Game.Genre",test6);
//        sqlSession.update("Game.Genre",test7);
//        sqlSession.update("Game.Genre",test8);
//        sqlSession.update("Game.Genre",test9);
//        sqlSession.update("Game.Genre",test10);
//        sqlSession.update("Game.Genre",test11);
//        sqlSession.update("Game.Genre",test12);
//        sqlSession.update("Game.Genre",test13);
//        sqlSession.update("Game.Genre",test14);
//        sqlSession.update("Game.Genre",test15);
//        sqlSession.update("Game.Genre",test16);
//        sqlSession.update("Game.Genre",test17);
//        sqlSession.update("Game.Genre",test18);
//        sqlSession.update("Game.Genre",test19);
//        sqlSession.update("Game.Genre",test20);
//        sqlSession.update("Game.Genre",test21);
//        sqlSession.update("Game.Genre",test22);
//        sqlSession.update("Game.Genre",test23);
//        sqlSession.update("Game.Genre",test24);
//        sqlSession.update("Game.Genre",test25);
//        sqlSession.update("Game.Genre",test26);
//        sqlSession.update("Game.Genre",test27);
//        sqlSession.update("Game.Genre",test28);
//        sqlSession.update("Game.Genre",test29);


    }

    @Override
    public void GInsert(ArrayList<String> g) {
            sqlSession.insert("Game.G",g.get(0));
            sqlSession.insert("Game.G",g.get(1));
            sqlSession.insert("Game.G",g.get(2));
            sqlSession.insert("Game.G",g.get(3));
            sqlSession.insert("Game.G",g.get(4));
            sqlSession.insert("Game.G",g.get(5));
            sqlSession.insert("Game.G",g.get(6));
            sqlSession.insert("Game.G",g.get(7));
            sqlSession.insert("Game.G",g.get(8));
            sqlSession.insert("Game.G",g.get(9));
            sqlSession.insert("Game.G",g.get(10));
            sqlSession.insert("Game.G",g.get(11));
            sqlSession.insert("Game.G",g.get(12));
            sqlSession.insert("Game.G",g.get(13));
            sqlSession.insert("Game.G",g.get(14));
            sqlSession.insert("Game.G",g.get(15));
            sqlSession.insert("Game.G",g.get(16));
            sqlSession.insert("Game.G",g.get(17));
            sqlSession.insert("Game.G",g.get(18));
            sqlSession.insert("Game.G",g.get(19));

    }


}
