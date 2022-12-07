package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardPager;
import com.project.board.vo.GameListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    BoardPager boardPager = new BoardPager();

    // 아이디 찾기 창
    @RequestMapping("/Board/findUserid")
    public String findUserid(){return "users/findUserid";}

    // 게임목록db에 넣기
    @RequestMapping("/GameListInsert")
    public String GameListInsert() throws IOException {
        boardService.GameInsert();
        return"board/GameList";
    }

    // 게임목록 조회 게시판
    @RequestMapping("/Board/GameList")
    public String GameList(Model model, @RequestParam HashMap<String,Object> map){

        List<GameListVo> gameListVo = null;
        int PageNum = Integer.parseInt((String) map.get("pageNum"));
        int ContentNum = Integer.parseInt((String) map.get("contentNum"));
        int so = 0;

        // 검색할 플랫폼 선택할때만 해당 플랫폼명으로 값을 String으로 변경
        if(map.get("searchType") != null) {
            int searchType = Integer.parseInt((String) map.get("searchType"));

            if (searchType == 1) {
                String sType = "PC패키지";
                map.put("sType", sType);
                so = 1;
            }
            if (searchType == 2) {
                String sType = "PC온라인";
                map.put("sType", sType);
                so = 2;
            }
            if (searchType == 3) {
                String sType = "모바일";
                map.put("sType", sType);
                so = 3;
            }
            if (searchType == 4) {
                String sType = "PS";
                map.put("sType", sType);
                so = 4;
            }
            if (searchType == 5) {
                String sType = "XBOX";
                map.put("sType", sType);
                so = 5;
            }
            if (searchType == 6) {
                String sType = "switch";
                map.put("sType", sType);
                so = 6;
            }
            if (searchType == 7) {
                String sType = "AR/VR";
                map.put("sType", sType);
                so = 7;
            }
            if (searchType == 8) {
                String sType = "인디";
                map.put("sType", sType);
                so = 8;
            }
            if (searchType == 9) {
                String sType = "HTML5";
                map.put("sType", sType);
                so = 9;
            }
        }

        boardPager.setTotalCount(boardService.GameListCount());
        boardPager.setPageNum(PageNum - 1);
        boardPager.setContentNum(ContentNum);
        boardPager.setCurrentBlock(PageNum);
        boardPager.setLastBlock();
        boardPager.prevNext(PageNum);
        boardPager.setStartPage();
        boardPager.setEndPage();
        map.put("pageNum", boardPager.getPageNum());
        map.put("contentNum", boardPager.getContentNum());

        if(map.get("sType") == null) {
            if (boardPager.getPageNum() == 0) {
                boardPager.setTotalCount(boardService.GameListCount());
                boardPager.setPageNum(PageNum - 1);
                boardPager.setContentNum(ContentNum);
                boardPager.setCurrentBlock(PageNum);
                boardPager.setLastBlock();
                boardPager.prevNext(PageNum);
                boardPager.setStartPage();
                boardPager.setEndPage();
                gameListVo = boardService.GameListSelect(map);
            } else if (boardPager.getPageNum() != 0) {
                map.put("pageNum", boardPager.getPageNum() * 30 + 1);
                boardPager.setTotalCount(boardService.GameListCount());
                boardPager.setPageNum(PageNum - 1);
                boardPager.setContentNum(ContentNum);
                boardPager.setCurrentBlock(PageNum);
                boardPager.setLastBlock();
                boardPager.prevNext(PageNum);
                boardPager.setStartPage();
                boardPager.setEndPage();
                gameListVo = boardService.GameListSelect(map);
            }
        }else if (map.get("sType") != null){
            if (boardPager.getPageNum() == 0) {
                boardPager.setTotalCount(boardService.GameListCount());
                boardPager.setPageNum(PageNum - 1);
                boardPager.setContentNum(ContentNum);
                boardPager.setCurrentBlock(PageNum);
                boardPager.setLastBlock();
                boardPager.prevNext(PageNum);
                boardPager.setStartPage();
                boardPager.setEndPage();
                gameListVo = boardService.GameListSearchS(map);
            } else if (boardPager.getPageNum() != 0) {
                map.put("pageNum", boardPager.getPageNum() * 30 + 1);
                boardPager.setTotalCount(boardService.GameListCount());
                boardPager.setPageNum(PageNum - 1);
                boardPager.setContentNum(ContentNum);
                boardPager.setCurrentBlock(PageNum);
                boardPager.setLastBlock();
                boardPager.prevNext(PageNum);
                boardPager.setStartPage();
                boardPager.setEndPage();
                gameListVo = boardService.GameListSearchS(map);
            }
        }

        model.addAttribute("GameList",gameListVo);
        model.addAttribute("Pager",boardPager);
        model.addAttribute("so",so);

        return "board/GameList";
    }

    }














