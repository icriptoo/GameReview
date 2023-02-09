package com.project.board.dao.impl;

import com.project.board.dao.BoardDao;
import com.project.board.vo.BoardVo;
import com.project.board.vo.DeclarationVo;
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
        for (int k = end; k >= 1 ; k--) {
            System.out.println(k);
            HashMap<String, Object> map = new HashMap<>();
            ArrayList<String> G = new ArrayList<>();
            ArrayList<String> GE = new ArrayList<>();
            ArrayList<String> IM = new ArrayList<>();
            ArrayList<String> GR = new ArrayList<>();
            int len = 0;
            int insize = 0;
            int i = 1;

            Document doc = Jsoup.connect("https://www.inven.co.kr/webzine/game/?of=post&page=" + k).get();
            // 게임명, 게임명(영문), 이미지, 평점, 게임정보 가져오기
            Elements elemG = doc.select("td[class=\"info\"]").select("ul[class=\"list\"]").select("li").select("span[class=\"game\"]");
            Elements elemGE = doc.select("td[class=\"info\"]").select("ul[class=\"list\"]").select("li").select("span[class=\"gameEn\"]");
            Elements elemIM = doc.select("td[class=\"thumb\"]").select("a[class=\"imgbox\"]").select("img");
            Elements elemGR = doc.select("td[class=\"info\"]").select("ul[class=\"list\"]").select("li");
            // 게임정보 저장
            for (Element e : elemGR) {
                GR.add(e.text());
            }
            // 게임명 저장
            for (Element e : elemG) {
                G.add(e.text());
            }
            // 게임이미지 저장
            for (Element e : elemIM) {
                IM.add(e.attr("src"));
            }
            // 영문게임명 저장
            for (Element e : elemGE) {
                GE.add(e.text());
            }
            // 한 페이지에 나와 있는 게임 갯수
            len = GR.size() / 6;
            i = len * 6 - 1;
            int ak = G.size() -1;
            for (int j = 0; j < len; j++) {
                int gck = 0;
                insize += 1;
                String[] Genre = GR.get(i - 4).split(":");
                String[] Company = GR.get(i - 3).split(":");
                String[] Service = GR.get(i - 2).split(":");
                String[] FlatForm = GR.get(i - 1).split(":");
                String[] Date = GR.get(i).split(":");
                map.put("g", G.get(ak));
                map.put("im", IM.get(ak));
                map.put("ge", GE.get(ak));
                map.put("gr", Genre[1]);
                map.put("cp", Company[1]);
                map.put("sv", Service[1]);
                map.put("pf", FlatForm[1]);
                map.put("id", Date[1]);
                if (!G.get(j).contains("삭제")){
                    gck = sqlSession.selectOne("Game.ckGame", map);
                    if (gck == 0) {
                        sqlSession.insert("Game.GInsert", map);
                    }
                }
                map.remove("g");
                map.remove("im");
                map.remove("ge");
                map.remove("gr");
                map.remove("cp");
                map.remove("sv");
                map.remove("pf");
                map.remove("id");
                ak -= 1;
                i -= 6;
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
    public List<BoardVo> getBoardList(HashMap<String, Object> map) { // 글 목록 가져오기
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
        sqlSession.update("Game.ScoreUpdate", map); //저장 후 해당게임 총평점 업데이트
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

    @Override
    public int boardCount(HashMap<String, Object> map) {
        return sqlSession.selectOne("Board.Count", map);
    }

    @Override
    public int declarationInsert(HashMap<String, Object> map) {
        int result = sqlSession.insert("Board.declarationInsert", map);
        return result;
    }

    @Override
    public List<DeclarationVo> getDeclarationList(HashMap<String, Object> map) {
        List<DeclarationVo> declarationVoList = sqlSession.selectList("Board.getDeclarationList",map);
        return declarationVoList;
    }

    @Override
    public DeclarationVo getDeclaration(HashMap<String, Object> map) {
        DeclarationVo declarationVo = sqlSession.selectOne("Board.getDeclaration", map);
        return declarationVo;
    }

    @Override
    public void declarationProcess(HashMap<String, Object> map) {
        sqlSession.update("Board.declarationProcess", map);
    }

    @Override
    public List<GameListVo> getTopGame() {
        List<GameListVo> topList = sqlSession.selectList("Game.getTopGame");
        return topList;
    }

    @Override
    public List<GameListVo> getGenreGame(HashMap<String, Object> map) {
        List<GameListVo> genreGameList = sqlSession.selectList("Game.getGenreGame", map);
        return genreGameList;
    }

    @Override
    public List<GameListVo> getGameList() {
        List<GameListVo> gameListVo = sqlSession.selectList("Game.GetGameList");
        return gameListVo;
    }

    @Override
    public int boardCheck(HashMap<String, Object> map) {
        int boardCheck = sqlSession.selectOne("Board.BoardCheck", map);
        return boardCheck;
    }

    //고평가 게임 뽑아오기
    @Override
    public BoardVo goodGame(HashMap<String, Object> map) {
        BoardVo boardVo = sqlSession.selectOne("Board.GoodGame", map);
        return boardVo;
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
