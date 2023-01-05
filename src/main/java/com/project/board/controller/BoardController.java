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
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
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

    //관리게시판 글목록 managementList
    @RequestMapping("managementList")
    public String managementList(@RequestParam HashMap<String, Object> map, Model model){
        int PageNum = Integer.parseInt((String) map.get("pageNum"));
        int ContentNum = Integer.parseInt((String) map.get("contentNum"));
        String menu_id = (String)map.get("menu_id");  //메뉴번호
        String searchType = (String) map.get("searchType");
        String keyword = (String) map.get("keyword");

        List<BoardVo> boardList = null;

        if (searchType == null){
            searchType = "a";
        }
        // 첫 화면에 나올 게시글 페이징
        if (searchType == "a") {
            map.put("management",1);
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
            boardList = boardService.getBoardList(map);  //글목록 불러오기
        }else { // 검색할때 사용하는 페이징
            map.put("management",2);
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
            boardList = boardService.getBoardList(map);
        }
        model.addAttribute("menu_id", menu_id );
        model.addAttribute("boardList", boardList );
        model.addAttribute("Pager", boardPager);
        model.addAttribute("sT",searchType);// 페이징용 검색유무
        model.addAttribute("kw",keyword);
        return "/board/managementList";
    }

    //글수정하기
    @RequestMapping("/boardUpdate")
    public String boardUpdate(@RequestParam HashMap<String, Object> map, Model model){
        String menu_id = (String)map.get("menu_id");
        String g_idx = (String)map.get("g_idx");
        boardService.boardUpdate(map);

        model.addAttribute("menu_id", menu_id ); //메뉴번호
        model.addAttribute("g_idx", g_idx ); //게임번호

        return "redirect:/GameReviewList?pageNum=1&contentNum=30";
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

        String path = null;
        if(menu_id.equals("1") || menu_id.equals("2")){
            path = "redirect:/GameReviewList?pageNum=1&contentNum=30";
        } else if(menu_id.equals("3")){
            path = "redirect:/managementList?pageNum=1&contentNum=30";
        }

        return path;
    }

    //글삭제하기
    @RequestMapping("/boardDelete")
    public String boardDelete(@RequestParam HashMap<String, Object> map, Model model){
        String menu_id = (String)map.get("menu_id");
        String g_idx = (String)map.get("g_idx");

        boardService.boardDelete(map);

        model.addAttribute("menu_id", menu_id ); //메뉴번호
        model.addAttribute("g_idx", g_idx ); //게임번호

        return "redirect:/GameReviewList?pageNum=1&contentNum=30";
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

    // 작성글 체크
    @ResponseBody
    @RequestMapping(value= "/boardCheck") // 글작성여부 체크
    public int regcheck(@RequestParam HashMap<String, Object> map) {
        int boardCheck = boardService.boardCheck(map);
        return  boardCheck;
    }

    //추천게임목록
    @RequestMapping("/RecomGameList")
    public String recomList(@RequestParam HashMap<String, Object> map, Model model) throws IOException, InterruptedException {
        BoardVo boardVo = boardService.goodGame(map);
        String title = boardVo.getG_name(); // 추천알고리즘 입력값으로 넣어줄 게임
        System.out.println("대상게임:" + title);

        ProcessBuilder builder;
        BufferedReader br;

        String arg1 = "C:/Python/Python39/python.exe"; //파이썬프로그램 경로
        String arg2 = "C:/GameReview/src/main/webapp/WEB-INF/pythonFile/gameRecom.py"; //파이썬코딩파일 경로

        //첫번째가 파이썬실행파일경로, 두번째가 추천알고리즘 파이썬파일 경로(arg1), 세번재가 넘겨줄 파라미터(title)
        //builder = new ProcessBuilder("C:/Python/Python39/python.exe", arg1, title); //python3 error
        builder = new ProcessBuilder(arg1, arg2, title); //python3 error

        builder.redirectErrorStream(true);
        Process process = builder.start();

        // 자식 프로세스가 종료될 때까지 기다림
        int exitval = process.waitFor();

        //// 서브 프로세스가 출력하는 내용을 받기 위해
        br = new BufferedReader(new InputStreamReader(process.getInputStream(),"euc-kr"));

        ArrayList<String> al = new ArrayList<>();

        //전처리 위해서 앞에 1줄(필요없는정보)을 버리기위함
        for(int i=0; i<1; i++) {
            br.readLine();
        }
        //여기서부터 읽어지는 줄이 게임제목
        for(int i=0; i<10; i++) { //(현재는 출력목록을 10개로 설정)
            al.add(br.readLine().trim());
            System.out.println(">>>  "+ i + ":" + al.get(i));
        }

        if(exitval !=0) {
            //비정상종료
            System.out.println("비정상종료");
        }

        //랜덤숫자 3개 뽑기 (중복 x)
        Random random = new Random();
        ArrayList<Integer> rIdx = new ArrayList<>();
        while(rIdx.size() < 3){
            int randomIdx = random.nextInt(al.size());
            for(int i=0; i<rIdx.size(); i++){
                if(rIdx.get(i) == randomIdx) {
                    rIdx.remove(Integer.valueOf(randomIdx));
                    break;
                }
            }
            rIdx.add(randomIdx);
        }

        //게임정보 담을 리스트 선언
        ArrayList<GameListVo> gameList = new ArrayList<>();

        //추천게임 정보가져오기
        for(int i=0; i<3; i++) {
            map.put("g_name", al.get(rIdx.get(i)));
            GameListVo gameListVo = boardService.getGame(map);
            gameList.add(gameListVo);
        }
        model.addAttribute("gameList", gameList);
        model.addAttribute("title", title);

        return "/board/recomGameList";
    }

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

        // 첫 화면에 나올 게시글 페이징
        if (searchType == "a") {
            boardPager.setTotalCount(boardService.boardOneCount(map));
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
        // 첫 화면에 나올 게시글 페이징
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
        List<GameListVo> gameListVo = boardService.getGameList();

        int resultCount =0;
        //C:/GameReview/src/main/webapp/WEB-INF/pythonFile/gamelist_221205_2.csv
        try{
            //BufferedWriter fw = new BufferedWriter(new FileWriter("C:/GameReview/src/main/webapp/WEB-INF/pythonFile/gamelist_test7.csv", true));
            BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/GameReview/src/main/webapp/WEB-INF/pythonFile/GameList.csv"),"MS949"));
            fw.write("G_IDX,G_NAME,G_GENRE,G_COMPANY,G_SERVICE,G_PLATFORM");
            fw.newLine();

            for(int i = 0; i < gameListVo.size(); ++i){
                int g_idx = gameListVo.get(i).getG_idx();
                String g_name = gameListVo.get(i).getG_name();
                g_name= g_name.replaceAll(",", "/").trim();
                String g_genre = gameListVo.get(i).getG_genre();
                g_genre= g_genre.replaceAll(",", "/").trim();
                String g_company = gameListVo.get(i).getG_company();
                g_company= g_company.replaceAll(",", "/").trim();
                String g_service = gameListVo.get(i).getG_service();
                g_service= g_service.replaceAll(",", "/").trim();
                String g_platform= gameListVo.get(i).getG_platform();
                g_platform= g_platform.replaceAll(",", "/").trim();

                fw.write(g_idx + ","+ g_name +","+ g_genre +","+ g_company +","+ g_service +","+ g_platform);
                fw.newLine();
            }

//            for(gameListVo : list){
//                fw.write(dom+","+"test");
//                fw.newLine();
//                resultCount++;
//                if(resultCount % 100 == 0)
//                    log.info("resultCount :"+resultCount + "/" + list.size());
//            }
            fw.flush();
            // 객체 닫기
            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
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














