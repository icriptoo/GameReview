package com.project.user.service;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component
public class Encrypt {
    private String salt1;
    private String result;

    public String getPw(String pw){
        //Salt 생성
        getSalt();
        System.out.println("salt: "+salt1);

        //최종 pwd 생성
        getEncrypt(pw, salt1);
        return result;
    }

    public void getSalt(){
        //1. Random, byte 객체 생성
        SecureRandom r = new SecureRandom();
        byte[] salt = new byte[20];

        //2. 난수 생성
        r.nextBytes(salt);

        //3. byte To Stirng(10진수의 문자열로 변경)
        StringBuffer sb = new StringBuffer();
        for (byte b : salt){
            sb.append(String.format("%02x",b));
        }
        salt1 = sb.toString();
    }

    public void getEncrypt(String pwd, String salt){
        try {
            //1. SHA256 알고리즘 객체 생성
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //2. pwd와 salt 합친 문자열에 SHA 256적용
            System.out.println("적용전: "+pwd+salt);
            md.update((pwd+salt).getBytes());
            byte[] pwdslat = md.digest();

            //3. btye To String(10진수의 문자열로 변경)
            StringBuffer sb = new StringBuffer();
            for (byte b : pwdslat){
                sb.append(String.format("%02x",b));
            }
            result = sb.toString();
            System.out.println("적용후: "+result);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

}
