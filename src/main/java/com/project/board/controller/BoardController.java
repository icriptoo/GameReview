package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardPager;
import com.project.board.vo.BoardVo;
import com.project.board.vo.GameListVo;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    BoardService boardService;

    BoardPager boardPager = new BoardPager();

    @RequestMapping("/")
    public String home() {
        return "/home";
    }

    //글수정하기
    @RequestMapping("/boardUpdate")
    public String boardUpdate(@RequestParam HashMap<String, Object> map, Model model){
        String menu_id = (String)map.get("menu_id");
        String g_idx = (String)map.get("g_idx");
        boardService.boardUpdate(map);

        model.addAttribute("menu_id", menu_id ); //메뉴번호
        model.addAttribute("g_idx", g_idx ); //게임번호

        return "redirect:/GameReviewList";
    }

    //글수정화면
    @RequestMapping("/updateForm")
    public String updateForm(@RequestParam HashMap<String, Object> map, Model model){
        BoardVo boardVo = boardService.getBoard(map);
        String menu_id = (String)map.get("menu_id");

        model.addAttribute("boardVo", boardVo ); // 글 불러오기
        model.addAttribute("menu_id", menu_id ); //메뉴정보

        return "/board/updateForm";
    }

    //글저장하기
    @RequestMapping("/boardInsert")
    public  String boardInsert(@RequestParam HashMap<String, Object> map, Model model){
        String menu_id = (String)map.get("menu_id");
        String g_idx = (String)map.get("g_idx");
        boardService.boardInsert(map);

        model.addAttribute("menu_id", menu_id ); //메뉴번호
        model.addAttribute("g_idx", g_idx ); //게임번호

        return "redirect:/GameReviewList";
    }

    //글삭제하기
    @RequestMapping("/boardDelete")
    public String boardDelete(@RequestParam HashMap<String, Object> map, Model model){
        String menu_id = (String)map.get("menu_id");
        String g_idx = (String)map.get("g_idx");

        boardService.boardDelete(map);

        model.addAttribute("menu_id", menu_id ); //메뉴번호
        model.addAttribute("g_idx", g_idx ); //게임번호

        return "redirect:/GameReviewList";
    }

    //글작성화면
    @RequestMapping("/boardWrite")
    public String boardWrite(@RequestParam HashMap<String, Object> map, Model model){
        String menu_id = (String)map.get("menu_id");
        String g_idx = (String)map.get("g_idx");

        model.addAttribute("menu_id", menu_id ); //메뉴번호
        model.addAttribute("g_idx", g_idx ); //게임번호

        return "/board/boardWrite";
    }

    // http://localhost:8080/GameReviewList?currentPage=1
    // defaultValue : 해당 요청 파라미터를 지정하지 않을 경우
    // defaultValue 속성에 지정한 문자열을 값으로 이용하게 됨
    //선택한 게임 글목록
    @RequestMapping("/GameReviewList")
    public String gameReview(@RequestParam HashMap<String, Object> map, Model model){
        int PageNum = Integer.parseInt((String) map.get("pageNum"));
        int ContentNum = Integer.parseInt((String) map.get("contentNum"));
        String menu_id = (String)map.get("menu_id");
        String searchType = (String) map.get("searchType");
        String keyword = (String) map.get("keyword");
        List<BoardVo> boardList = null;

        GameListVo gameListVo = boardService.getGame(map);

        if (searchType == null){
            searchType = "a";
        }
        // 첫 화면에 나올 게시글 가져오기
        if (searchType == "a") {
            boardPager.setTotalCount(boardService.boardCount(map));
            boardPager.setPageNum(PageNum - 1);
            boardPager.setContentNum(ContentNum);
            boardPager.setCurrentBlock(PageNum);
            boardPager.setLastBlock();
            boardPager.prevNext(PageNum);
            boardPager.setStartPage();
            boardPager.setEndPage();
            if(boardPager.getPageNum() != 0){
                boardPager.setPageNum((PageNum - 1) * 30 + 1);
            }
            map.put("pageNum", boardPager.getPageNum());
            map.put("contentNum", boardPager.getContentNum());
            boardList = boardService.getBoardList(map);
        }else { // 검색할때 사용하는 페이징
            boardPager.setTotalCount(boardService.boardSCount(map));
            boardPager.setPageNum(PageNum - 1);
            boardPager.setContentNum(ContentNum);
            boardPager.setCurrentBlock(PageNum);
            boardPager.setLastBlock();
            boardPager.prevNext(PageNum);
            boardPager.setStartPage();
            boardPager.setEndPage();
            if(boardPager.getPageNum() != 0){
                boardPager.setPageNum((PageNum - 1) * 30 + 1);
            }
            map.put("pageNum", boardPager.getPageNum());
            map.put("contentNum", boardPager.getContentNum());
            boardList = boardService.getSBoardList(map);
        }

        model.addAttribute("gameListVo", gameListVo ); //해당게임정보 불러오기
        model.addAttribute("menu_id", menu_id ); //메뉴번호
        model.addAttribute("boardList", boardList ); //해당게임리뷰목록 불러오기
        model.addAttribute("Pager", boardPager);
        model.addAttribute("sT",searchType);// 페이징용 검색유무
        model.addAttribute("kw",keyword);

        return "/board/GameReviewList";
    }

    //전체 글목록
    @RequestMapping("/totalList")
    public String totalList(@RequestParam HashMap<String, Object> map, Model model){
        int PageNum = Integer.parseInt((String) map.get("pageNum"));
        int ContentNum = Integer.parseInt((String) map.get("contentNum"));
        String menu_id = (String)map.get("menu_id");
        String searchType = (String) map.get("searchType");
        String keyword = (String) map.get("keyword");
        List<BoardVo> boardList = null;

        if (searchType == null){
            searchType = "a";
        }
        // 첫 화면에 나올 게시글 가져오기
        if (searchType == "a") {
            boardPager.setTotalCount(boardService.boardCount(map));
            boardPager.setPageNum(PageNum - 1);
            boardPager.setContentNum(ContentNum);
            boardPager.setCurrentBlock(PageNum);
            boardPager.setLastBlock();
            boardPager.prevNext(PageNum);
            boardPager.setStartPage();
            boardPager.setEndPage();
            if(boardPager.getPageNum() != 0){
              boardPager.setPageNum((PageNum - 1) * 30 + 1);
            }
            map.put("pageNum", boardPager.getPageNum());
            map.put("contentNum", boardPager.getContentNum());
            boardList = boardService.getBoardList(map);
        }else { // 검색할때 사용하는 페이징
            boardPager.setTotalCount(boardService.boardSCount(map));
            boardPager.setPageNum(PageNum - 1);
            boardPager.setContentNum(ContentNum);
            boardPager.setCurrentBlock(PageNum);
            boardPager.setLastBlock();
            boardPager.prevNext(PageNum);
            boardPager.setStartPage();
            boardPager.setEndPage();
            if(boardPager.getPageNum() != 0){
                boardPager.setPageNum((PageNum - 1) * 30 + 1);
            }
            map.put("pageNum", boardPager.getPageNum());
            map.put("contentNum", boardPager.getContentNum());
            boardList = boardService.getSBoardList(map);
        }

        model.addAttribute("boardList", boardList ); //전체 글목록 불러오기
        model.addAttribute("menu_id", menu_id ); //메뉴번호
        model.addAttribute("Pager", boardPager);
        model.addAttribute("sT",searchType);// 페이징용 검색유무
        model.addAttribute("kw",keyword);

        return "/board/totalList";
    }

    //글 내용 화면
    @RequestMapping("/View")
    public String view(@RequestParam HashMap<String, Object> map, Model model){
        BoardVo boardVo = boardService.getBoard(map);
        String menu_id = (String)map.get("menu_id");
        String pageNum = (String)map.get("pageNum");
        String contentNum = (String)map.get("contentNum");

        model.addAttribute("boardVo", boardVo ); // 글 불러오기
        model.addAttribute("menu_id", menu_id ); //메뉴정보
        model.addAttribute("pageNum", pageNum); // 댓글페이지번호
        model.addAttribute("contentNum", contentNum); //댓글가져오는 마지막 번호

        return "/board/view";
    }

    // 게임목록db에 넣기
    @RequestMapping("/GameListInsert")
    public String GameListInsert() throws IOException {
        boardService.GameInsert();
        return "/home";
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
    @RequestMapping("/Board/GameRecom")
    public String GameList() throws InterruptedException, IOException {
        String arg1;
        String title = "토탈워: 워해머3"; // 나중에 리스트로 리뷰한 게임 중 평점 높은걸로 여러가지 넣는걸로 바꿔야함
        ProcessBuilder builder;
        BufferedReader br;

        arg1 = "C:/GameReview/src/main/webapp/WEB-INF/pythonFile/gameRecom.py";
        //C:/GameReview/src/main/webapp/WEB-INF/pythonFile/gameRecom.py
        //C:/Users/ekrxj/PycharmProjects/pythonProject/gameRecom.py

        //첫번째가 파이썬실행파일경로, 두번째가 추천알고리즘 파이썬파일 경로(arg1), 세번재가 넘겨줄 파라미터(title)
        //builder = new ProcessBuilder("C:/Python/Python39/python.exe", arg1, title); //python3 error
        builder = new ProcessBuilder("C:/Users/GGG/AppData/Local/Programs/Python/Python39/python.exe", arg1, title); //python3 error

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














