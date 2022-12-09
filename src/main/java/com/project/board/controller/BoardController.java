package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardPager;
import com.project.board.vo.GameListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    BoardPager boardPager = new BoardPager();

    @RequestMapping("/")
    public String home(){ return "/home";}

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

    @RequestMapping("/Board/GameRecom")
    public String GameList() throws InterruptedException, IOException {
        System.out.println("pythonbuilder ");
        String arg1;
        String title = "토탈워: 워해머3";
        ProcessBuilder builder;
        BufferedReader br;

        arg1 = "C:/GameReview/src/main/webapp/WEB-INF/pythonFile/gameRecom.py";
        //C:/GameReview/src/main/webapp/WEB-INF/pythonFile/gameRecom.py
        //C:/Users/ekrxj/PycharmProjects/pythonProject/gameRecom.py

        //첫번째가 파이썬실행파일경로, 두번째가 추천알고리즘 파이썬파일 경로(arg1), 세번재가 넘겨줄 파라미터(title)
        builder = new ProcessBuilder("C:/Python/Python39/python.exe", arg1, title); //python3 error

        builder.redirectErrorStream(true);
        Process process = builder.start();

        // 자식 프로세스가 종료될 때까지 기다림
        int exitval = process.waitFor();

        //// 서브 프로세스가 출력하는 내용을 받기 위해
        br = new BufferedReader(new InputStreamReader(process.getInputStream(),"euc-kr"));


        ArrayList<String> al = new ArrayList<>();

        //전처리 위해서 앞에 1줄(필요없는정보)을 버리기위함
        br.readLine();
//        for(int i=0; i<1; i++) {
//            br.readLine();
//        }
        //여기서부터 읽어지는 줄이 게임제목
        for(int i=0; i<5; i++) { //(현재는 출력목록을 5개로 설정)
            al.add(br.readLine().trim());
            System.out.println(">>>  "+ i + ":" + al.get(i));
        }
        //랜덤하게 추천게임중하나 뽑기 테스트 중
        Random random = new Random();
        int randomIndex = random.nextInt(al.size());
        System.out.println(al.get(randomIndex));


        if(exitval !=0){
            //비정상종료
            System.out.println("비정상종료");
        }

        return "/home";

    }

}














