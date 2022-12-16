package com.project.user.controller;

import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 로그인 창 이동
    @RequestMapping("login")
    public String login(@RequestParam HashMap<String, Object> map, Model model){
        String url= "";
        String next = (String) map.get("next");
        String next1 = next.substring(21);
        if(map.get("contentNum") != null) {
            String conN = (String) map.get("contentNum");
            url = next + "&contentNum=" + conN;
            model.addAttribute("next",url);
        }else {
            model.addAttribute("next", next1);
        }
        return "user/login";
    }

    // 로그인
    @RequestMapping("loginProcess")
    public String loginProcess(HttpSession httpSession, @RequestParam HashMap<String, Object> map, Model model){

        String returnURL = "";
        String next = (String) map.get("next");
        String url = "";
        model.addAttribute("next",next);
        if (map.get("contentNum") != null) {
            String next1 = (String) map.get("contentNum");
            url = next + "&contentNum=" + next1;
        }else {
            url = next;
        }

        if(httpSession.getAttribute("login") != null){
            httpSession.removeAttribute("login");
        }
        UserVo vo = userService.login(map);

        if(vo != null) {
            httpSession.setAttribute("login", vo);
            returnURL = "redirect:"+ url;
        }else{
            model.addAttribute("fail","로그인 실패");
            returnURL = "user/login";
        }
        return returnURL;
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
        return "redirect:"+ url;
    }

    // 마이페이지
    @RequestMapping("/mypage")
    public ModelAndView mypage(HttpSession httpSession){
        ModelAndView mv = new ModelAndView();
        Object getUser = userService.getUser(httpSession.getAttribute("login"));
        mv.addObject(getUser);
        mv.setViewName("user/mypage");

        return mv;
    }

    // 내 정보 수정할 때 필요한 현재 정보를 가져옴
    @RequestMapping("/user/profilupdateform")
    public ModelAndView profilupdateform(HttpSession httpSession) {
        ModelAndView mv = new ModelAndView();
        Object getUser = userService.getUser(httpSession.getAttribute("login"));

        mv.addObject(getUser);
        mv.setViewName("user/profilupdate");

        return mv;
    }

    // 수정된 내 정보를 업데이트 후 업데이트된 내용을 마이페이지에 보여줌
    @RequestMapping("/user/profilupdate")
    public ModelAndView profilupdate(@RequestParam HashMap<String, Object> map, HttpSession httpSession){
        ModelAndView mv = new ModelAndView();
        userService.userupdate(map);
        Object vo = userService.getUser(httpSession.getAttribute("login"));

        httpSession.removeAttribute("login");
        httpSession.setAttribute("login",vo);

        mv.addObject(vo);
        mv.setViewName("user/mypage");
        return mv;
    }

    // 프로필 사진 업데이트 창 띄우기
    @RequestMapping("/user/profileupdateform")
    public String profileUpdateForm(){ return"user/profileupdate"; }

    // 선택한 프로필 사진 업데이트
    @RequestMapping("/profileupdate")
    public String profileUpdate(@RequestParam HashMap<String, Object> map, HttpServletRequest request, HttpSession httpSession){
        userService.profileupdate(map, request, httpSession);
        Object vo = userService.getUser(httpSession.getAttribute("login"));

        httpSession.removeAttribute("login");
        httpSession.setAttribute("login",vo);

        return "user/popupout";
    }

    //회원가입 창 이동
    @RequestMapping("/signupform")
    public String SignUpForm(){ return "user/signup"; }

    // 회원가입
    @RequestMapping("/signup")
    public String SignUp(@RequestParam HashMap<String, Object> map){
        // 질문 if문으로 변환시킬것
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
        String check = "";

        if (uid != null){
            check = "아이디는 " + uid +" 입니다.";
            return check;
        }else {
            check = "아이디와 이메일을 확인 해주세요.";
            return check;
        }
    }
}