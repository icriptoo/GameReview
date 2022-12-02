package com.project.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    // preHandle() : controller 보다 먼저 실행되는 메소드
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {
        HttpSession httpSession = request.getSession();

        String requestUrl = request.getRequestURL().toString();
        // 페이지 들어왔을 때 기본 화면으로 보내는 예외 처리

        if(requestUrl.equals("http://localhost:8080/")){
            return true;
        }
        //로그인 화면도 예외 처리
        if(requestUrl.contains("/login")){
            return true;
        }
        //회원가입 화면 예외 처리
        if(requestUrl.contains("/writeForm")) {
            return true;
        }
        //유저 아이디 찾는 화면 예외 처리
        if(requestUrl.contains("/findUserid")) {
            return true;
        }
        //비밀번호 찾는 화면 예외 처리
        if(requestUrl.contains("/changePasswdForm")) {
            return true;
        }
        //회원가입 예외처리
        if(requestUrl.contains("/write")) {
            return true;
        }
        //로그인 예외처리
        if(requestUrl.contains("/loginProcess")) {
            return true;
        }
        
        //유저 아이디 찾기에서 중복확인 예외처리
        if(requestUrl.contains("/getUserid")) {
            return true;
        }

        //회원가입 창에서 중복확인 예외처리
        if(requestUrl.contains("/useridCheck")) {
            return true;
        }

        //비밀번호 변경창에서 비밀번호 변경 예외 처리
        if(requestUrl.contains("/changePasswd")) {
            return true;
        }

        //인증번호 예외 처리
        if(requestUrl.contains("/YA")) {
            return true;
        }

        //회원가입 예외 처리
        if(requestUrl.contains("/userInsert")) {
            return true;
        }
        //해주세요 게시판 예외 처리
        if(requestUrl.contains("/Board/customerList")){
            return true;
        }


        Object obj = httpSession.getAttribute("login");
        if (obj == null){
            response.sendRedirect("/login");
            return false;
        }
        return super.preHandle(request, response, handler);

    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception{
        super.postHandle(request, response, handler, modelAndView);
    }
}