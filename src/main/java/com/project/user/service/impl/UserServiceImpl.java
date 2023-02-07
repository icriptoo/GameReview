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
import java.util.List;

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
    public UserVo getUserChPw(HashMap<String, Object> map) {
        UserVo userVo = userDao.getUserChPw(map);
        return userVo;
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
    public String getPcode(HashMap<String, Object> map) {
        return userDao.getPcode(map);
    }

    @Override
    public String getckpw(HashMap<String, Object> map) {
        return userDao.getckpw(map);
    }

    @Override
    public void changePw(HashMap<String, Object> map) {
        userDao.changePw(map);
    }


    @Override
    public UserVo getUser(Object login) {
        UserVo user = userDao.getUser(login);
        return user;
    }

    @Override
    public List<UserVo> getUserList() {
        List<UserVo> userVoList = userDao.getUserList();
        return userVoList;
    }

    @Override
    public UserVo authorityCheck(String u_id) {
        UserVo user = userDao.authorityCheck(u_id);
        return user;
    }

    @Override
    public List<UserVo> getSUserList(HashMap<String, Object> map) {
        return userDao.getSUserList(map);
    }

    @Override
    public int getUserCount(HashMap<String, Object> map) {
        return userDao.getUserCount(map);
    }
}
