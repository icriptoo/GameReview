package com.project.user.dao.impl;

import com.project.user.dao.UserDao;
import com.project.user.vo.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public UserVo login(HashMap<String, Object> map) {
        UserVo uVo = sqlSession.selectOne("User.login",map);
        return uVo;
    }
}
