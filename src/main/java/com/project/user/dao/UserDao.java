package com.project.user.dao;

import com.project.user.vo.UserVo;

import java.util.HashMap;

public interface UserDao {

    UserVo login(HashMap<String, Object> map);

    void userupdqte(HashMap<String, Object> map);

    Object getUser(Object login);

    void profileupdate(HashMap<String, Object> map);

    String useridCheck(HashMap<String, Object> map);

    String nnCheck(HashMap<String, Object> map);

    void userInsert(HashMap<String, Object> map);

    String getuserId(HashMap<String, Object> map);
}
