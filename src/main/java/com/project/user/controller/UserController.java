package com.project.user.controller;

import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(){
        return "/user/login";
    }
    @RequestMapping("loginProcess")
    public String loginProcess(HttpSession httpSession, @RequestParam HashMap<String, Object> map, Model model){

        String returnURL = "";

        String next = (String) map.get("next");
        String next1 = next.substring(21);
        String url = "";
        if (map.get("contentNum") != null) {
            String next2 = (String) map.get("contentNum");
            url = next1 + "&contentNum=" + next2;
        }else {
            url = next1;
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

    @RequestMapping(value = "/logout", method= {RequestMethod.GET})
    public String logout(HttpServletRequest request, @RequestParam HashMap<String,Object> map){

        String next = (String) map.get("link");
        String next1 = next.substring(21);
        String url = "";
        if (map.get("contentNum") != null) {
            String next2 = (String) map.get("contentNum");
            url = next1 + "&contentNum=" + next2;
        }else {
            url = next1;
        }

        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:"+ url;
    }

}