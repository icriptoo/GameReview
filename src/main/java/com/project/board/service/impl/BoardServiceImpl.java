package com.project.board.service.impl;

import com.project.board.dao.BoardDao;
import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import com.project.board.vo.DeclarationVo;
import com.project.board.vo.GameListVo;
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
    public GameListVo getGame(HashMap<String, Object> map) {
        GameListVo gameListVo = boardDao.getGame(map);
        return gameListVo;
    }

    @Override
    public List<BoardVo> getBoardList(HashMap<String, Object> map) {
        List<BoardVo> boardList = boardDao.getBoardList(map);
        return boardList;
    }

    @Override
    public BoardVo getBoard(HashMap<String, Object> map) {
        BoardVo boardVo = boardDao.getBoard(map);
        return boardVo;
    }

    //글 저장하기
    @Override
    public void boardInsert(HashMap<String, Object> map) {
        boardDao.boardInsert(map);
    }

    @Override
    public void boardUpdate(HashMap<String, Object> map) {
        boardDao.boardUpdate(map);
    }

    @Override
    public int boardCount(HashMap<String, Object> map) {
        return boardDao.boardCount(map);
    }

    @Override
    public List<GameListVo> getGameList() {
        List<GameListVo> gameListVo = boardDao.getGameList();

        return gameListVo;
    }

    @Override
    public int boardCheck(HashMap<String, Object> map) {
        int boardCheck = boardDao.boardCheck(map);
        return boardCheck;
    }

    @Override
    public BoardVo goodGame(HashMap<String, Object> map) {
        BoardVo boardVo = boardDao.goodGame(map);
        return boardVo;
    }

    @Override
    public void boardDelete(HashMap<String, Object> map) {
        boardDao.boardDelete(map);
    }

    @Override
    public int declarationInsert(HashMap<String, Object> map) {
        int result = boardDao.declarationInsert(map);
        return result;
    }

    @Override
    public List<DeclarationVo> getDeclarationList() {
        List<DeclarationVo> declarationVoList = boardDao.getDeclarationList();
        return declarationVoList;
    }

    @Override
    public DeclarationVo getDeclaration(HashMap<String, Object> map) {
        DeclarationVo declarationVo = boardDao.getDeclaration(map);
        return declarationVo;
    }

    @Override
    public void declarationProcess(HashMap<String, Object> map) {
        boardDao.declarationProcess(map);
    }

    @Override
    public List<GameListVo> getTopGame() {
        List<GameListVo> topList = boardDao.getTopGame();
        return topList;
    }

    @Override
    public List<GameListVo> getGenreGame(HashMap<String, Object> map) {
        List<GameListVo> genreGameList = boardDao.getGenreGame(map);
        return genreGameList;
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

    @Override
    public List<GameListVo> GameListSearchS(HashMap<String, Object> map) {
        List<GameListVo> gameSList = boardDao.GameListSearchS(map);
        return gameSList;
    }

    @Override
    public int GameListSCount(HashMap<String, Object> map) {
        return boardDao.GameListSCount(map);
    }

    @Override
    public int GameSCount(HashMap<String, Object> map) {
        return boardDao.GameSCount(map);
    }

    @Override
    public List<GameListVo> GameListS(HashMap<String, Object> map) {
        return boardDao.GameListS(map);
    }




}


