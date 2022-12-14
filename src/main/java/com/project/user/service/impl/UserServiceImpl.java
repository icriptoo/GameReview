package com.project.user.service.impl;

import com.project.user.dao.UserDao;
import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserVo login(HashMap<String, Object> map) {
        UserVo uVo = userDao.login(map);
        return uVo;
    }
}
