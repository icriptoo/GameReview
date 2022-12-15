package com.project.user.service.impl;

import com.project.user.service.PdsFile;
import com.project.user.dao.UserDao;
import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Override
    public void userupdate(UserVo userVo) {
        userDao.userupdqte(userVo);
    }

    @Override
    public void profileupdate(HashMap<String, Object> map, HttpServletRequest request, HttpSession httpSession) {
        PdsFile.save(map, request, httpSession);
        userDao.profileupdate(map);
    }

    @Override
    public String useridCheck(HashMap<String, Object> map) {
        String idck = userDao.useridCheck(map);
        return idck;
    }

    @Override
    public String nnCheck(HashMap<String, Object> map) {
        String nnck = userDao.nnCheck(map);
        return nnck;
    }

    @Override
    public void userInsert(HashMap<String, Object> map) {
        userDao.userInsert(map);
    }

    @Override
    public Object getUser(Object login) {
        Object getUser = userDao.getUser(login);
        return getUser;
    }
}
