package com.project.user.dao;

import com.project.user.vo.UserVo;

import java.util.HashMap;
import java.util.Map;

public interface UserDao {
    UserVo login(HashMap<String, Object> map);

    void userInsert(UserVo vo);


    Object getUser(Object login);

    void userUpdate(UserVo userVo);

    void userDelete(UserVo userVo);

    String getUserid(UserVo userVo);

    String useridCheck(UserVo userVo);

    void changePasswd(UserVo userVo);
}
