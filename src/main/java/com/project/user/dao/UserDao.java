package com.project.user.dao;

import com.project.user.vo.UserVo;

import java.util.HashMap;

public interface UserDao {

    UserVo login(HashMap<String, Object> map);
}
