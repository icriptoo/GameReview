package com.project.user.service;

import com.project.user.vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public interface UserService {

    UserVo login(HashMap<String, Object> map);


    Object getUser(Object login);

    void userupdate(HashMap<String, Object> userVo);

    void profileupdate(HashMap<String, Object> map, HttpServletRequest request, HttpSession httpSession) throws IOException;

    String useridCheck(HashMap<String, Object> map);

    String nnCheck(HashMap<String, Object> map);

    void userInsert(HashMap<String, Object> map);

    String getuserId(HashMap<String, Object> map);

    String emailck(HashMap<String, Object> map);

    String getpw(HashMap<String, Object> map);

    String finduidck(HashMap<String, Object> map);

    String findpwck(HashMap<String, Object> map);
}
