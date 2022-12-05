package com.project.board.dao;

import com.project.board.vo.BoardVo;
import com.project.board.vo.GameListVo;
import com.project.board.vo.ReviewVo;
import com.project.board.vo.RiderBoardVo;
import com.project.reply.vo.ReplyVo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface BoardDao {

    void C_insertboard(BoardVo boardVo);
    void R_insertboard(RiderBoardVo riderboardVo);
    void RV_insertboard(ReviewVo reviewVo);

    BoardVo DetailCustomer(HashMap<String, Object> map);

    RiderBoardVo DetailRider(HashMap<String, Object> map);

    ReviewVo DetailReview(HashMap<String, Object> map);

    void CBoardUpdate(HashMap<String, Object> map);

    void RBoardUpdate(HashMap<String, Object> map);

    void RVBoardUpdate(HashMap<String, Object> map);

    void CBoardDelete(HashMap<String, Object> map);

    void RBoardDelete(HashMap<String, Object> map);
    void RVBoardDelete(HashMap<String, Object> map);
    // 고객게시글 모두 조회
    public List<BoardVo> customerList(HashMap<String, Object> map);
    // 검색 고객게시물 리스트 조회
    List<BoardVo> CSList(HashMap<String, Object> map);
    public List<BoardVo> reviewList(HashMap<String, Object> map);
    public List<RiderBoardVo> riderList(HashMap<String, Object> map);

    public int customerCount();
    public int reviewCount();
    public int riderCount();

    int testCount();

    List<BoardVo> testList(HashMap<String, Object> map);

    List<ReplyVo> replyList(HashMap<String, Object> map);

    int replyCount(HashMap<String, Object> map);

    void CBoardCheck(HashMap<String, Object> map);

    void RBoardCheck(HashMap<String, Object> map);

    int CSCount(HashMap<String, Object> map);

    List<RiderBoardVo> RSList(HashMap<String, Object> map);

    int RSCount(HashMap<String, Object> map);

    List<BoardVo> RVSList(HashMap<String, Object> map);

    int RVSCount(HashMap<String, Object> map);

    List<BoardVo> myWritePage(String nickname);

    List<RiderBoardVo> myRWritePage(String nickname);

    List<ReviewVo> myRVwritePage(String nickname);

    void GameInsert() throws IOException;

    int GameListCount();


    List<GameListVo> GameListSelect(HashMap<String, Object> map);
}
