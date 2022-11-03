package com.project.board.service.impl;

import com.project.board.dao.BoardDao;
import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDao boardDao;

    @Override
    public List<BoardVo> getBoardList(String menu_id) {
        List<BoardVo> boardList = boardDao.getBoardList(menu_id);
        return boardList;
    }

    @Override
    public List<BoardVo> getBoardView(int board_number){
        List<BoardVo> boardList = boardDao.getBoardView(board_number);
        return boardList;
    }

    @Override
    public void insertboard(BoardVo boardVo) {
        boardDao.insertboard(boardVo);
    }
}
