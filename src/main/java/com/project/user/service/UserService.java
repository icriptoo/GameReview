package com.project.user.service;

import com.project.user.vo.UserVo;

import java.util.HashMap;

public interface UserService {

    UserVo login(HashMap<String, Object> map);
}
