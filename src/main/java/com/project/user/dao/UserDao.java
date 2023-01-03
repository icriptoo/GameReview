package com.project.user.dao;

import com.project.user.vo.UserVo;

import java.util.HashMap;

public interface UserDao {

    UserVo login(HashMap<String, Object> map);

    void userupdqte(HashMap<String, Object> map);

    UserVo getUser(Object login);

    void profileupdate(HashMap<String, Object> map);

    String useridCheck(HashMap<String, Object> map);

    String nnCheck(HashMap<String, Object> map);

    void userInsert(HashMap<String, Object> map);

    String getuserId(HashMap<String, Object> map);

    String emailck(HashMap<String, Object> map);

    UserVo getUserChPw(HashMap<String, Object> map);

    String finduidck(HashMap<String, Object> map);

    String findpwck(HashMap<String, Object> map);

    void wirthdwal(HashMap<String, Object> map);

    String getPcode(HashMap<String, Object> map);

    String getckpw(HashMap<String, Object> map);

    void changePw(HashMap<String, Object> map);
}
