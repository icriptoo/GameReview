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
        //로그인 화면도 예외 처리
        if(requestUrl.contains("/Board/GameList")){
            return true;
        }
        //로그인 화면도 예외 처리
        if(requestUrl.contains("/topGame")){
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