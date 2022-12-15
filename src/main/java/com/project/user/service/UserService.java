package com.project.user.service;

import com.project.user.vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public interface UserService {

    UserVo login(HashMap<String, Object> map);


    Object getUser(Object login);

    void userupdate(UserVo userVo);

    void profileupdate(HashMap<String, Object> map, HttpServletRequest request, HttpSession httpSession);

    String useridCheck(HashMap<String, Object> map);

    String nnCheck(HashMap<String, Object> map);

    void userInsert(HashMap<String, Object> map);
}
