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
        //전체게시판
        if(requestUrl.contains("/totalList")){
            return true;
        }
        //회원가입
        if(requestUrl.contains("/signupform")){
            return true;
        }
        //아이디찾기
        if(requestUrl.contains("/findUseridform")){
            return true;
        }
        //비밀번호찾기
        if(requestUrl.contains("/findPasswordform")){
            return true;
        }
        //공지사항
        if(requestUrl.contains("/managementList")){
            return true;
        }
        //아이디중복확인
        if(requestUrl.contains("useridCheck")){
            return true;
        }
        //닉네임중복확인
        if(requestUrl.contains("nnCheck")){
            return true;
        }
        //이메일중복확인
        if(requestUrl.contains("emailck")){
            return true;
        }
        //비밀번호 정규식체크
        if(requestUrl.contains("ckPwJ")){
            return true;
        }
        //창닫기
        if(requestUrl.contains("popupout")){
            return true;
        }
        //아이디찾기 결과출력
        if(requestUrl.contains("getUserid")){
            return true;
        }
        //비밀번호변경에 필요한 아이디, 이메일확인
        if(requestUrl.contains("changePwIdCk")){
            return true;
        }
        //아이디,비밀번호 찾기 이메일 인증번호 전송
        if(requestUrl.contains("findemailck")){
            return true;
        }
        //아이디,비밀번호 찾기 이메일 인증번호 확인
        if(requestUrl.contains("findecodeck")){
            return true;
        }
        //비밀번호변경
        if(requestUrl.contains("changePw")){
            return true;
        }
        //마이페이지 인증번호 확인
        if(requestUrl.contains("/user/ecodeck")){
            return true;
        }
        //마이페이지 닉네임중복확인
        if(requestUrl.contains("/user/nnCheck")){
            return true;
        }
       //마이페이지 이메일등록 중복체크 후 인증번호 전송
        if(requestUrl.contains("/user/email")){
            return true;
        }
        //댓글조회
        if(requestUrl.contains("/replyselect")){
            return true;
        }
        //댓글페이징
        if(requestUrl.contains("/replyP")){
            return true;
        }
        //답글조회
        if(requestUrl.contains("/commentList")){
            return true;
        }
        //
        if(requestUrl.contains("")){
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