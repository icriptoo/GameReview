package com.project.user.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardPager;
import com.project.user.service.CheckPassword;
import com.project.user.service.Encrypt;
import com.project.user.service.MailSendService;
import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSendService mailService;

    @Autowired
    private Encrypt encrypt;

    @Autowired
    private CheckPassword checkPassword;

    @Autowired
    BoardService boardService;

    BoardPager boardPager = new BoardPager();

    // 이메일 인증번호 저장변수
    private String ecode = "";

    //회원정보리스트
    @RequestMapping("userList")
    public String userList(@RequestParam HashMap<String, Object> map, Model model, HttpSession httpSession){
        UserVo vo = userService.getUser(httpSession.getAttribute("login"));
        if(!vo.getAuthority().equals("0")){
            model.addAttribute("msg", "권한이 없습니다.");
            model.addAttribute("url", "/");
            return "/alert";
        }
        int PageNum = Integer.parseInt((String) map.get("pageNum"));
        int ContentNum = Integer.parseInt((String) map.get("contentNum"));
        String searchType = (String) map.get("searchType");
        String keyword = (String) map.get("keyword");
        List<UserVo> userVoList =  null ;

        if (searchType == null){ // 검색유무 확인
            searchType = "a";
        }
        if (searchType.equals("a")) {
            boardPager.setTotalCount(userService.getUserCount(map));
            boardPager.setPageNum(PageNum - 1);
            boardPager.setContentNum(ContentNum);
            boardPager.setCurrentBlock(PageNum);
            boardPager.setLastBlock();
            boardPager.prevNext(PageNum);
            boardPager.setStartPage();
            boardPager.setEndPage();
            if (boardPager.getPageNum() != 0) {
                boardPager.setPageNum((PageNum - 1) * 30 + 1);
            }
            map.put("pageNum", boardPager.getPageNum());
            map.put("contentNum", boardPager.getContentNum());

            userVoList = userService.getUserList();
        } else {
            boardPager.setTotalCount(userService.getUserCount(map));
            boardPager.setPageNum(PageNum - 1);
            boardPager.setContentNum(ContentNum);
            boardPager.setCurrentBlock(PageNum);
            boardPager.setLastBlock();
            boardPager.prevNext(PageNum);
            boardPager.setStartPage();
            boardPager.setEndPage();
            if (boardPager.getPageNum() != 0) {
                boardPager.setPageNum((PageNum - 1) * 30 + 1);
            }
            map.put("pageNum", boardPager.getPageNum());
            map.put("contentNum", boardPager.getContentNum());

            userVoList = userService.getSUserList(map);
        }

        model.addAttribute("list", userVoList);
        model.addAttribute("Pager", boardPager);
        model.addAttribute("sT",searchType);// 페이징용 검색유무
        model.addAttribute("kw",keyword);
        return "/admin/userList";
    }

    // 로그인 창 이동
    @RequestMapping("login")
    public String login(@RequestParam HashMap<String, Object> map, Model model){
        String url= "";
        if(map.get("contentNum") != null) {
            String conN = (String) map.get("contentNum");
            model.addAttribute("next",url);
        }
        return "user/login";
    }

    // 로그인
    @RequestMapping("loginProcess")
    public String loginProcess(HttpSession httpSession, @RequestParam HashMap<String, Object> map, Model model){
        UserVo vo = null;
        String returnURL = "";
        String next = (String) map.get("next");
        String url = "";
        String pw = (String)map.get("pw");
        // db에 id검색해서 pcode(회원가입할때 만들어진 salt) 가져옴
        String salt = userService.getPcode(map);
        // 입력한 비밀번호와 가져온 salt를 sha256 암호화
        String Epw = encrypt.getEncrypt(pw,salt);
        // db에 id에 등록되어 있는 암호화된 비밀번호 가져옴
        String ckpw = userService.getckpw(map);
        // 암호화된 비밀번호 비교
        if ( Epw.equals(ckpw)){
            map.put("pw",Epw);
            if(httpSession.getAttribute("login") != null){
                httpSession.removeAttribute("login");
            }
            vo = userService.login(map);
            if (vo == null){
                model.addAttribute("fail","아이디와 비밀번호를 확인해 주세요.");
                return "user/login";
            }
            // 나중에 로그인 후 원래 있던 페이지로 이동하기 위한 주소지정 - 지금사용 안함
            /*
            model.addAttribute("next",next);
            if (map.get("contentNum") != null) {
                String next1 = (String) map.get("contentNum");
                url = next + "&contentNum=" + next1;
            }else {
                url = next;
            }
            returnURL = "redirect:"+ url;
            */
            vo.setCpw(pw);
            httpSession.setAttribute("login", vo);
            return "redirect:/";
        }else {
            model.addAttribute("fail","아이디와 비밀번호를 확인해 주세요.");
            returnURL = "";
            return "user/login";
        }

        //return returnURL;
    }

    // 로그아웃
    @RequestMapping(value = "/logout", method= {RequestMethod.GET})
    public String logout(HttpServletRequest request, @RequestParam HashMap<String,Object> map){
        String next = (String) map.get("next");
        String url = "";
        if (map.get("contentNum") != null) {
            String next1 = (String) map.get("contentNum");
            url = next + "&contentNum=" + next1;
        }else {
            url = next;
        }

        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        //return "redirect:"+ url;
        return "redirect:/";
    }

    // 마이페이지
    @RequestMapping("/mypage")
    public String mypage(HttpSession httpSession, HashMap<String, Object> map){
        UserVo user = userService.getUser(httpSession.getAttribute("login"));
        if (user == null){
            httpSession.invalidate();
            return "redirect:/";
        }
        map.put("user",user);
        return "user/mypage";
    }

    // 내 정보 수정할 때 필요한 현재 정보를 가져와 페이지에 보여줌
    @RequestMapping("/user/profilupdateform")
    public String profilupdateform(HttpSession httpSession, HashMap<String, Object> map) {
        UserVo user = userService.getUser(httpSession.getAttribute("login"));
        map.put("user",user);
        return "user/profilupdate";
    }

    // 수정된 내 정보를 업데이트 후 업데이트된 내용을 마이페이지에 보여줌
    @RequestMapping("/user/profilupdate")
    public String profilupdate(@RequestParam HashMap<String, Object> map, HttpSession httpSession){
        userService.userupdate(map);
        UserVo user = userService.getUser(httpSession.getAttribute("login"));
        httpSession.removeAttribute("login");
        httpSession.setAttribute("login", user);

        map.put("user", user);

        return "redirect:/mypage";
    }

    // 프로필 사진 업데이트 창 띄우기
    @RequestMapping("/user/profileupdateform")
    public String profileUpdateForm(){ return"user/profileupdate"; }

    // 선택한 프로필 사진 업데이트
    @RequestMapping("/profileupdate")
    public String profileUpdate(@RequestParam HashMap<String, Object> map, HttpServletRequest request, HttpSession httpSession) throws IOException {
        userService.profileupdate(map, request, httpSession);
        Object vo = userService.getUser(httpSession.getAttribute("login"));

        httpSession.removeAttribute("login");
        httpSession.setAttribute("login",vo);

        return "popupout";
    }

    //회원가입 창 이동
    @RequestMapping("/signupform")
    public String SignUpForm(){ return "user/signup"; }

    // 회원가입
    @RequestMapping("/signup")
    public String SignUp(@RequestParam HashMap<String, Object> map){
        String pw = (String)map.get("pw");
        String Pcode = encrypt.getSalt();
        String Epw = encrypt.getEncrypt(pw,Pcode);
        map.put("pw",Epw);
        map.put("pcode",Pcode);
        userService.userInsert(map);
        return "user/login";
    }

    // 회원가입 아이디 중복확인
    @RequestMapping(value="/useridCheck", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String useridCheck(@RequestParam HashMap<String,Object> map){
        String useridCheck = userService.useridCheck(map);
        String check = "";

        if (useridCheck != null){
            check = "중복된 아이디입니다.";
            return check;
        } else {
            check = "중복되지 않은 아이디입니다.";
            return check;
        }
    }

    // 회원가입 닉네임 중복확인
    @RequestMapping(value="/nnCheck", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String nnCheck(@RequestParam HashMap<String,Object> map){
        String nnCheck = userService.nnCheck(map);
        String check = "";

        if (nnCheck != null){
            check = "중복된 닉네임입니다.";
            return check;
        } else {
            check = "중복되지 않은 닉네임입니다.";
            return check;
        }
    }

    // 이메일 중복확인
    @RequestMapping(value="/emailck", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String emailCk(@RequestParam HashMap<String, Object> map){
        String mse = "";
        String email = userService.emailck(map);
        if (email != null){
            mse = "이미 사용중인 이메일입니다." ;
        } else {
            mse = "사용 가능한 이메일입니다.";
        }
        return mse;
    }

    // 프로필 닉네임 중복확인
    @RequestMapping(value="/user/nnCheck", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String pronnCheck(@RequestParam HashMap<String, Object> map){
        String nnCheck = userService.nnCheck(map);
        String check = "";

        if (nnCheck != null){
            check = "중복된 닉네임입니다.";
            return check;
        } else {
            check = "중복되지 않은 닉네임입니다.";
            return check;
        }
    }

    // 비밀번호 정규식 패턴확인
    @RequestMapping(value = "/ckPwJ", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String ckPwJ(@RequestParam HashMap<String, Object> map){
        String mse ="";
        String ck = "";
        String u_id = (String)map.get("u_id");
        String pw = (String)map.get("pw");
        UserVo vo = null;
        String ckpw = "";

        if (map.size() >= 3) {
            ck = (String) map.get("ck");
        } else {
            ckpw = userService.findpwck(map);
            vo = userService.getUserChPw(map);
        }

        if (ck == "") {
            mse = checkPassword.ckPw(pw, u_id);
            if (mse == "") {
                mse = "올바른 비밀번호입니다.";
            }
        } else{
            mse = checkPassword.ckPw(pw, u_id);
            String Pcode = userService.getPcode(map);
            String Epw = encrypt.getEncrypt(pw, Pcode);
            if (Epw.equals(ckpw)) {
                mse = "기존 비밀번호와 동일합니다.";
            }
            if (mse == "") {
                mse = "올바른 비밀번호입니다.";
            }
        }
        return mse;
    }

    // 아이디찾기 창 띄우기
    @RequestMapping("/findUseridform")
    public String findUserid(){
        return "user/findUserid";
    }

    // 아이디찾기
    @RequestMapping(value = "/getUserid", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String getuserId(@RequestParam HashMap<String, Object> map){
        String uid = userService.getuserId(map);
        String mse = "";

        if (uid != null){
            return mse = "아이디는 " + uid +" 입니다.";
        }else {
            return mse = "닉네임과 이메일을 다시 확인해 주세요.";
        }
    }

    // 비밀번호 변경 창 띄우기
    @RequestMapping("/findPasswordform")
    public String findpassword(){ return "user/findPassword"; }

    // 비밀번호 변경 창
    // 아이디와 이메일 가지고 비밀번호 변경 가능한지 확인
    @RequestMapping(value = "/changePwIdCk", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String changePwIdCk(@RequestParam HashMap<String, Object> map){
        UserVo userVo = userService.getUserChPw(map);
        String mse ="";

        if (userVo != null){
            mse = "y";
        } else if (userVo == null){
            mse = "n";
        }
        return mse;
    }

    // 비밀번호 변경
    @RequestMapping("/changePw")
    public String changePw(@RequestParam HashMap<String, Object> map, HttpSession httpSession){
        String pw = (String)map.get("pw");
        String Pcode = userService.getPcode(map);
        String Epw = encrypt.getEncrypt(pw,Pcode);
        map.put("pw",Epw);
        map.put("pcode",Pcode);
        userService.changePw(map);

        return "popupout";
    }

    // 아이디, 비밀번호 찾기 이메일 인증번호 전송
    @RequestMapping(value = "/findemailck", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String findemailck(@RequestParam HashMap<String, Object> map){
        String email = (String) map.get("email"); // 입력한 이메일
        String u_id = "";
        String n_name = "";
        String mse = "";
        String eck = "";
        if (map.get("u_id") != null){
            u_id = (String) map.get("u_id");
        } else if (map.get("n_name") != null){
            n_name = (String) map.get("n_name");
        }
        if (n_name != ""){
            eck = userService.finduidck(map);
            if (eck != null) {
                ecode = mailService.joinEmail(email);
                System.out.println("인증번호:"+ecode);
                mse = "인증번호가 전송 됐습니다.";
            } else {
                mse = "닉네임과 이메일을 확인해 주세요.";
            }
        }else if (u_id != ""){
            eck = userService.findpwck(map);
            if (eck != null) {
                ecode = mailService.joinEmail(email);
                System.out.println("인증번호:"+ecode);
                mse = "인증번호가 전송 됐습니다.";
            } else {
                mse = "아이디와 이메일을 확인해 주세요.";
            }
        }
        return mse;
    }

    // 아이디, 비밀번호 찾기 인증번호 체크
    @RequestMapping(value = "/findecodeck", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String findecodeck(@RequestParam HashMap<String, Object> map){
        String ecodeck = (String) map.get("ecodeck");
        String mse = "";
        if (ecode.length() > 0) {
            if (ecodeck.equals(ecode)) {
                mse = "인증번호가 일치합니다.";
            } else {
                mse = "인증번호가 일치하지 않습니다.";
            }
        }
        return mse;
    }

    // 마이페이지 이메일등록 중복체크 후 인증번호 전송
    @RequestMapping(value = "/user/email", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String email(@RequestParam HashMap<String, Object> map){
        String email = (String) map.get("email"); // 입력한 이메일
        String mse = "";
        String eck = userService.emailck(map); // 이메일 중복확인
        if (eck == null) {
            ecode = mailService.joinEmail(email);
            System.out.println("인증번호:"+ecode);
            mse = "인증번호가 전송 됐습니다.";
        }else if(eck != null){
            mse = "중복된 이메일입니다.";
        }else {
            mse = "이메일을 확인해 주세요.";
        }
        return mse;
    }

    // 마이페이지 인증번호 체크
    @RequestMapping(value = "/user/ecodeck", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String ecodeck(@RequestParam HashMap<String, Object> map){
        String ecodeck = (String) map.get("ecodeck");
        String mse = "";
        if (ecodeck.equals(ecode)){
            mse = "인증번호가 일치합니다.";
        }else {
            mse = "인증번호가 일치하지 않습니다.";
        }
        return mse;
    }

    //회원탈퇴 페이지 이동
    @RequestMapping("/user/WithdrawalForm")
    public String withdrawalForm(){ return "/user/Withdrawal"; }

    //회원탈퇴
    @RequestMapping("/user/Wirthdrwal")
    public String withdrawal(HttpSession httpSession,@RequestParam HashMap<String, Object> map, Model model){
        map.put("withdrawal","OFF");
        userService.wirthdrwal(map);
        String chk = (String)map.get("path");
        if(chk != null){
            List<UserVo> userVoList = userService.getUserList();
            model.addAttribute("list", userVoList);
            return "redirect:/userList";
        }
        httpSession.invalidate();
        return "redirect:/";
    }

    // 창닫기
    @RequestMapping("/popupout")
    public String popupout(){ return "popupout"; }

}