package com.project.board.dao.impl;

import com.project.board.dao.BoardDao;
import com.project.board.vo.BoardVo;
import com.project.board.vo.GameListVo;
import com.project.board.vo.ReviewVo;
import com.project.board.vo.RiderBoardVo;
import com.project.reply.vo.ReplyVo;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
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

    // 2022-12-02 강지찬 크롤링
    @Override
    public void GameInsert() throws IOException {

        int end = 364;

        // 인벤게임db 사이트에서 게임정보 크롤링
        for (int k = 364; k <= end; k++) {
            HashMap<String, Object> map = new HashMap<>();
            ArrayList<String> G = new ArrayList<>();
            ArrayList<String> GE = new ArrayList<>();
            ArrayList<String> IM = new ArrayList<>();
            ArrayList<String> SC = new ArrayList<>();
            ArrayList<String> GR = new ArrayList<>();

            Document doc = Jsoup.connect("https://www.inven.co.kr/webzine/game/?page=" + k).get();

            Elements elemG = doc.select("td[class=\"info\"]").select("ul[class=\"list\"]").select("li").select("span[class=\"game\"]");
            Elements elemGE = doc.select("td[class=\"info\"]").select("ul[class=\"list\"]").select("li").select("span[class=\"gameEn\"]");
            Elements elemIM = doc.select("td[class=\"thumb\"]").select("a[class=\"imgbox\"]").select("img");
            Elements elemSC = doc.select("td[class=\"score\"]").select("div");
            Elements elemGR = doc.select("td[class=\"info\"]").select("ul[class=\"list\"]").select("li");

            // 게임정보 저장
            for (Element e : elemGR) {
                GR.add(e.text());
            }

            int grC = 0;
            // 장르명 저장
            for (int i = 1; i < 169; i += 6) {
                String[] Genre = GR.get(i).split(":");
                map.put("gr" + grC, Genre[1]);
                grC += 1;
            }

            int cpC = 0;
            // 개발사 저장
            for (int i = 2; i < 169; i += 6) {
                String[] Genre = GR.get(i).split(":");
                map.put("cp" + cpC, Genre[1]);
                cpC += 1;
            }

            int svC = 0;
            // 서비스 저장
            for (int i = 3; i < 169; i += 6) {
                String[] Genre = GR.get(i).split(":");
                map.put("sv" + svC, Genre[1]);
                svC += 1;
            }

            int pfC = 0;
            // 플랫폼 저장
            for (int i = 4; i < 169; i += 6) {
                String[] Genre = GR.get(i).split(":");
                map.put("pf" + pfC, Genre[1]);
                pfC += 1;
            }

            int idC = 0;
            // 출시일 저장
            for (int i = 5; i < 181; i += 6) {
                String[] Genre = GR.get(i).split(":");
                map.put("id" + idC, Genre[1]);
                idC += 1;
            }

            // 게임이미지 저장
            for (Element e : elemIM) {
                IM.add(e.attr("src"));
            }
            for (int j = 0; j < IM.size(); j++) {
                map.put("im" + j, IM.get(j));
            }

            // 평점 저장
            for (Element e : elemSC) {
                SC.add(e.text());
            }
            for (int j = 0; j < IM.size(); j++) {
                map.put("sc" + j, SC.get(j));
            }

            // 게임명 저장
            for (Element e : elemG) {
                G.add(e.text());
            }
            for (int j = 0; j < IM.size(); j++) {
                map.put("g" + j, G.get(j));
            }

            // 영문게임명 저장
            for (Element e : elemGE) {
                GE.add(e.text());
            }
            for (int j = 0; j < IM.size(); j++) {
                map.put("ge" + j, GE.get(j));
            }
            for(int i=0;i<=27;i++) {
                sqlSession.insert("Game.G"+i, map);
            }
        }

    }

    @Override
    public int GameListCount() {
        return sqlSession.selectOne("Game.GCount");
    }

    @Override
    public List<GameListVo> GameListSelect(HashMap<String, Object> map) {
        List<GameListVo> gameList = sqlSession.selectList("Game.GList",map);
        return gameList;
    }
}
