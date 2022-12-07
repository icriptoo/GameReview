package com.project.board.service.impl;

import com.project.board.dao.BoardDao;
import com.project.board.service.BoardService;
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


}


