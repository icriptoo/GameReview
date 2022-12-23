package com.project.board.dao.impl;

import com.project.board.dao.BoardDao;
import com.project.board.vo.BoardVo;
import com.project.board.vo.GameListVo;
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
    public void GameListDelete() { sqlSession.delete("Game.GameListDelete"); }

    // 2022-12-02 강지찬 크롤링
    @Override
    public void GameInsert() throws IOException {
        // 마지막 페이지 계산
        ArrayList<String> EP = new ArrayList<>();
        Document doe = Jsoup.connect("https://www.inven.co.kr/webzine/game/?page=1").get();
        Elements endP = doe.select("a[class=\"pg\"]");

        for (Element e : endP){
            EP.add(e.text());
        }
        String EnP = EP.get(9);

        int end = Integer.parseInt(EnP);

        // 인벤게임db 사이트에서 게임정보 크롤링
        for (int k = 1; k <= end; k++) {
            HashMap<String, Object> map = new HashMap<>();
            ArrayList<String> G = new ArrayList<>();
            ArrayList<String> GE = new ArrayList<>();
            ArrayList<String> IM = new ArrayList<>();
            ArrayList<String> SC = new ArrayList<>();
            ArrayList<String> GR = new ArrayList<>();

            Document doc = Jsoup.connect("https://www.inven.co.kr/webzine/game/?page=" + k).get();
            // 게임명, 게임명(영문), 이미지, 평점, 게임정보 가져오기
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
            for (int i = 1; i <= GR.size(); i += 6) {
                String[] Genre = GR.get(i).split(":");
                map.put("gr" + grC, Genre[1]);
                grC += 1;
            }

            int cpC = 0;
            // 개발사 저장
            for (int i = 2; i <= GR.size(); i += 6) {
                String[] Genre = GR.get(i).split(":");
                map.put("cp" + cpC, Genre[1]);
                cpC += 1;
            }

            int svC = 0;
            // 서비스 저장
            for (int i = 3; i <= GR.size(); i += 6) {
                String[] Genre = GR.get(i).split(":");
                map.put("sv" + svC, Genre[1]);
                svC += 1;
            }

            int pfC = 0;
            // 플랫폼 저장
            for (int i = 4; i <= GR.size(); i += 6) {
                String[] Genre = GR.get(i).split(":");
                map.put("pf" + pfC, Genre[1]);
                pfC += 1;
            }

            int idC = 0;
            // 출시일 저장
            for (int i = 5; i <= GR.size(); i += 6) {
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
            for (int i = 0; i <= (GR.size()/6)-1; i++) {
                sqlSession.insert("Game.G" + i, map);
            }
        }
    }

    // 전체 게임 수 구하기
    @Override
    public int GameListCount() {
        return sqlSession.selectOne("Game.GCount");
    }

    // 검색한 게임 수 구하기
    @Override
    public int GameListSCount(HashMap<String, Object> map) {
        return sqlSession.selectOne("Game.GSCount",map);
    }

    @Override
    public int GameSCount(HashMap<String, Object> map) {
        return sqlSession.selectOne("Game.GameSC",map);
    }

    @Override
    public List<GameListVo> GameListS(HashMap<String, Object> map) {
        return sqlSession.selectList("Game.GameLS",map);
    }

    // 게임정보가져오기
    @Override
    public GameListVo getGame(HashMap<String, Object> map) {return sqlSession.selectOne("Game.GetGame",map);}

    @Override
    public List<BoardVo> boardListSelect(HashMap<String, Object> map) { // 글 목록 가져오기
        List<BoardVo> boardList = sqlSession.selectList("Board.List", map);
        return boardList;
    }

    @Override
    public BoardVo getBoard(HashMap<String, Object> map) {
        sqlSession.update("Board.ReadCountUpdate", map ); // 조회수 증가
        BoardVo boardVo = sqlSession.selectOne("Board.View", map); // 글 가져오기
        return boardVo;
    }

    @Override
    public void boardDelete(HashMap<String, Object> map) {
        sqlSession.delete( "Board.Delete",map); // 글 삭제
    }

    @Override
    public void boardInsert(HashMap<String, Object> map) {
        sqlSession.insert("Board.BoardInsert", map); // 글저장
        sqlSession.update("Game.ScoreUpdate", map); //저장 후 해당게임 총평점 업데이트

    }

    @Override
    public void boardUpdate(HashMap<String, Object> map) {
        sqlSession.update("Board.BoardUpdate", map); // 글 수정
        sqlSession.update("Game.ScoreUpdate", map); //수정 후 해당게임 총평점 업데이트
    }

    // 전체게임리스트 뽑기
    @Override
    public List<GameListVo> GameListSelect(HashMap<String, Object> map) {
        List<GameListVo> gameList = sqlSession.selectList("Game.GList",map);
        return gameList;
    }

    // 검색한 게임리스트 뽑기
    @Override
    public List<GameListVo> GameListSearchS(HashMap<String, Object> map) {
        List<GameListVo> gameSList = null;

        gameSList = sqlSession.selectList("Game.GSList", map);

        return gameSList;
    }
}
