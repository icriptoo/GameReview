package com.project.user.dao.impl;

import com.project.user.dao.UserDao;
import com.project.user.vo.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession sqlSession;

    //로그인할 때 사용
    @Override
    public UserVo login(HashMap<String, Object> map) {
        UserVo vo = this.sqlSession.selectOne("User.login", map);
        return vo;
    }

    
    //회원가입할 때 사용
    @Override
    public void userInsert(UserVo userVo) {
        this.sqlSession.insert("User.UserInsert", userVo);
    }

    
    //회원정보 상세내용 불러올 때 사용
    @Override
    public Object getUser(Object login) {
        Object getUser = this.sqlSession.selectOne("User.GetUser", login);
        return getUser;
    }

    
    //회원정보 수정할 때 사용
    @Override
    public void userUpdate(UserVo userVo) {
        this.sqlSession.update("User.UserUpdate",userVo);
    }


    //회원탈퇴할 때 사용
    @Override
    public void userDelete(UserVo userVo) {
        this.sqlSession.delete("User.UserDelete",userVo);
    }

    //유저 아이디 찾기에서 사용
    @Override
    public String getUserid(UserVo userVo) {
        UserVo getUserid = this.sqlSession.selectOne("User.getUserid", userVo);
        if (getUserid != null) {
            String realUserid = getUserid.getuserid();
            return realUserid;
        } else{
            return null;
        }

    }

    //유저아이디 중복체크할 때 사용
    @Override
    public String useridCheck(UserVo userVo) {
        UserVo useridCheck = this.sqlSession.selectOne("User.useridCheck", userVo);
        if (useridCheck != null) {
            String check = useridCheck.getuserid();
        return check;
        } else{
            return null;
        }
    }

    @Override
    public void changePasswd(UserVo userVo) {
        sqlSession.update("User.changePasswd", userVo);

    }
}
