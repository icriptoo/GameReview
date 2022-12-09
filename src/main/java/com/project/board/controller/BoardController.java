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

    @RequestMapping("/")
    public String home() {
        return "/home";
    }

    // 게임목록db에 넣기
    @RequestMapping("/GameListInsert")
    public String GameListInsert() throws IOException {
        boardService.GameInsert();
        return "board/GameList";
    }

    // 게임목록 조회 게시판
    @RequestMapping("/Board/GameList")
    public String GameList(Model model, @RequestParam HashMap<String, Object> map) {

        List<GameListVo> gameListVo = null;
        int PageNum = Integer.parseInt((String) map.get("pageNum"));
        int ContentNum = Integer.parseInt((String) map.get("contentNum"));
        int searchType = 0;
        String gN = "";
        String sType = "";


        if (map.get("searchType") != null) {
            searchType = Integer.parseInt((String) map.get("searchType"));
        }
        if (map.get("gameName") != null) {
            gN = (String) map.get("gameName");
        }

        // 플랫폼, 장르 등 선택한 select 걸로 표시용
        int so = 0;


        // 검색할 플랫폼 선택할때만 해당 플랫폼명으로 값 변경
        if (searchType < 50) {
            map.put("type", "G_PLATFORM");
            if (searchType == 1) {
                sType = "PC패키지";
                map.put("sType", sType);
                so = 1;
            }
            if (searchType == 2) {
                sType = "PC온라인";
                map.put("sType", sType);
                so = 2;
            }
            if (searchType == 3) {
                sType = "모바일";
                map.put("sType", sType);
                so = 3;
            }
            if (searchType == 4) {
                sType = "PS";
                map.put("sType", sType);
                so = 4;
            }
            if (searchType == 5) {
                sType = "XBOX";
                map.put("sType", sType);
                so = 5;
            }
            if (searchType == 6) {
                sType = "switch";
                map.put("sType", sType);
                so = 6;
            }
            if (searchType == 7) {
                sType = "AR/VR";
                map.put("sType", sType);
                so = 7;
            }
            if (searchType == 8) {
                sType = "인디";
                map.put("sType", sType);
                so = 8;
            }
            if (searchType == 9) {
                sType = "HTML5";
                map.put("sType", sType);
                so = 9;
            }
        }

        // 검색할 장르 선택할때만 해당 플랫폼명으로 값 변경
        if (searchType > 50) {
            map.put("type", "G_GENRE");

            if (searchType == 51) {
                sType = "RPG";
                map.put("sType", sType);
                so = 51;
            }
            if (searchType == 52) {
                sType = "어드벤쳐";
                map.put("sType", sType);
                so = 52;
            }
            if (searchType == 53) {
                sType = "FPS";
                map.put("sType", sType);
                so = 53;
            }
            if (searchType == 54) {
                sType = "스포츠";
                map.put("sType", sType);
                so = 54;
            }
            if (searchType == 55) {
                sType = "TCG";
                map.put("sType", sType);
                so = 55;
            }
            if (searchType == 56) {
                sType = "보드";
                map.put("sType", sType);
                so = 56;
            }
            if (searchType == 57) {
                sType = "레이싱";
                map.put("sType", sType);
                so = 57;
            }
            if (searchType == 58) {
                sType = "슈팅";
                map.put("sType", sType);
                so = 58;
            }
            if (searchType == 59) {
                sType = "액션";
                map.put("sType", sType);
                so = 59;
            }
            if (searchType == 60) {
                sType = "시뮬레이션";
                map.put("sType", sType);
                so = 60;
            }
            if (searchType == 61) {
                sType = "RTS";
                map.put("sType", sType);
                so = 61;
            }
            if (searchType == 62) {
                sType = "퍼즐";
                map.put("sType", sType);
                so = 62;
            }
            if (searchType == 63) {
                sType = "리듬액션";
                map.put("sType", sType);
                so = 63;
            }
            if (searchType == 64) {
                sType = "SNG";
                map.put("sType", sType);
                so = 64;
            }
            if (searchType == 65) {
                sType = "AOS";
                map.put("sType", sType);
                so = 65;
            }
            if (searchType == 66) {
                sType = "기타";
                map.put("sType", sType);
                so = 66;
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

        // 검색한 게임 출력
        if(map.get("gameName") != null){
            System.out.println("검색");
            if (boardPager.getPageNum() == 0) {
                boardPager.setTotalCount(boardService.GameSCount(map));
                boardPager.setPageNum(PageNum - 1);
                boardPager.setContentNum(ContentNum);
                boardPager.setCurrentBlock(PageNum);
                boardPager.setLastBlock();
                boardPager.prevNext(PageNum);
                boardPager.setStartPage();
                boardPager.setEndPage();
                gameListVo = boardService.GameListS(map);
            } else if (boardPager.getPageNum() != 0) {
                map.put("pageNum", boardPager.getPageNum() * 30 + 1);
                boardPager.setTotalCount(boardService.GameSCount(map));
                boardPager.setPageNum(PageNum - 1);
                boardPager.setContentNum(ContentNum);
                boardPager.setCurrentBlock(PageNum);
                boardPager.setLastBlock();
                boardPager.prevNext(PageNum);
                boardPager.setStartPage();
                boardPager.setEndPage();
                gameListVo = boardService.GameListS(map);
            }
            searchType = 101;
        }else if (map.get("sType") == null) { // 모든게임 출력
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
        } else if (map.get("sType") != null) { // 원하는 게임 검색
            if (boardPager.getPageNum() == 0) {
                boardPager.setTotalCount(boardService.GameListSCount(map));
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
                boardPager.setTotalCount(boardService.GameListSCount(map));
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
        model.addAttribute("GameList", gameListVo);
        model.addAttribute("Pager", boardPager);
        model.addAttribute("so", so);
        model.addAttribute("sT", searchType);
        model.addAttribute("gN", gN);

        return "board/GameList";
    }

}














