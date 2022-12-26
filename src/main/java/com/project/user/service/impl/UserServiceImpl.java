package com.project.user.service.impl;

import com.project.user.dao.UserDao;
import com.project.user.service.PdsFile;
import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    public void userupdate(HashMap<String, Object> map) {
        userDao.userupdqte(map);
    }

    @Override
    public void profileupdate(HashMap<String, Object> map, HttpServletRequest request, HttpSession httpSession) throws IOException {
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
    public String getuserId(HashMap<String, Object> map) {
        String uid = userDao.getuserId(map);
        return uid;
    }

    @Override
    public String emailck(HashMap<String, Object> map) {
        String eck = userDao.emailck(map);
        if (eck != null){
            return eck;
        }else {
            return null;
        }
    }

    @Override
    public String getpw(HashMap<String, Object> map) {
        String pw = userDao.getpw(map);
        return pw;
    }

    @Override
    public String finduidck(HashMap<String, Object> map) {
        String uid = userDao.finduidck(map);
        return uid;
    }

    @Override
    public String findpwck(HashMap<String, Object> map) {
        String pw = userDao.findpwck(map);
        return pw;
    }

    @Override
    public void wirthdrwal(HashMap<String, Object> map) {
        userDao.wirthdwal(map);
    }

    @Override
    public Object getUser(Object login) {
        Object getUser = userDao.getUser(login);
        return getUser;
    }
}
