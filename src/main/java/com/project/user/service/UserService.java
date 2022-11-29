package com.project.user.service;

import com.project.user.vo.UserVo;

import java.util.HashMap;


public interface UserService {

    void userInsert(UserVo vo);

    UserVo login(HashMap<String, Object> map);
    Object getUser(Object login);

    void userUpdate(UserVo userVo);

    void userDelete(UserVo userVo);

    String getUserid(UserVo userVo);

    String useridCheck(UserVo userVo);

    void changePasswd(UserVo userVo);
}
