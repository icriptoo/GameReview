package com.project.user.service;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CheckPassword {


    public String ckPw(String pw, String u_id) {
        Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
        Matcher passMatcher1 = passPattern1.matcher(pw);

        if (!passMatcher1.find()) {
            return "영문과 특수문자 숫자를 포함하며 8자 이상이어야 합니다.";
        }

        // 반복된 문자 확인
        Pattern passPattern2 = Pattern.compile("(\\w)\\1\\1\\1");
        Matcher passMatcher2 = passPattern2.matcher(pw);

        if (passMatcher2.find()) {
            return "동일한 문자를 연속해서 사용할 수 없습니다.";
        }

        // 아이디 포함 확인
        if (pw.contains(u_id)) {
            return "ID를 포함할 수 없습니다.";
        }

        // 특수문자 확인
        Pattern passPattern3 = Pattern.compile("\\W");
        Pattern passPattern4 = Pattern.compile("[!@$%^*+=-]");

        for (int i = 0; i < pw.length(); i++) {
            String s = String.valueOf(pw.charAt(i));
            Matcher passMatcher3 = passPattern3.matcher(s);

            if (passMatcher3.find()) {
                Matcher passMatcher4 = passPattern4.matcher(s);
                if (!passMatcher4.find()) {
                    return "특수문자는 !@$^*+=-만 사용 가능합니다.";
                }
            }
        }
        return "";
    }
}
