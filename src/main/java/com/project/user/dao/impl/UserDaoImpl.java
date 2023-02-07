package com.project.user.dao.impl;

import com.project.user.dao.UserDao;
import com.project.user.vo.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public UserVo login(HashMap<String, Object> map) {
        UserVo uVo = sqlSession.selectOne("User.login",map);
        if (uVo.getWithdrawal().equals("OFF")){
            uVo = null;
        }
        return uVo;
    }

    @Override
    public void userupdqte(HashMap<String, Object> map) {
        sqlSession.update("User.UserUpdate", map);
    }

    @Override
    public UserVo getUser(Object login) {
        UserVo user = sqlSession.selectOne("User.getUser",login);
        return user;
    }

    @Override
    public void profileupdate(HashMap<String, Object> map) {
        sqlSession.update("User.profileupdate",map);
    }

    @Override
    public String useridCheck(HashMap<String, Object> map) {
        UserVo idck = sqlSession.selectOne("User.idCheck", map);
        if (idck != null){
            String check =idck.getU_id();
            return check;
        }else {
            return null;
        }
    }

    @Override
    public String nnCheck(HashMap<String, Object> map) {
        UserVo nnck = sqlSession.selectOne("User.nnCheck",map);
        if(nnck != null){
            String check = nnck.getN_name();
            return check;
        }else {
            return null;
        }
    }

    @Override
    public void userInsert(HashMap<String, Object> map) {
        sqlSession.insert("User.UserInsert", map);
    }

    @Override
    public String getuserId(HashMap<String, Object> map) {
        String uid = sqlSession.selectOne("User.getuserId",map);
        if (uid != null){
            return uid;
        }else {
            return null;
        }
    }

    @Override
    public String emailck(HashMap<String, Object> map) {
        String eck = sqlSession.selectOne("User.getmail", map);
        return eck;
    }

    @Override
    public UserVo getUserChPw(HashMap<String, Object> map) {
        UserVo userVo = sqlSession.selectOne("User.getUserChPw",map);
        return userVo;
    }

    @Override
    public String finduidck(HashMap<String, Object> map) {
        String uid = sqlSession.selectOne("User.finduid",map);
        if (uid != null){
            return uid;
        }else {
            return null;
        }
    }

    @Override
    public String findpwck(HashMap<String, Object> map) {
        String pw = sqlSession.selectOne("User.findpw",map);
        if (pw != null){
            return pw;
        }else {
            return null;
        }
    }

    @Override
    public void wirthdwal(HashMap<String, Object> map) {
        sqlSession.update("User.wirthdwal",map);
    }

    @Override
    public String getPcode(HashMap<String, Object> map) {
        return sqlSession.selectOne("User.getPcode", map);
    }

    @Override
    public String getckpw(HashMap<String, Object> map) {
        return sqlSession.selectOne("User.getckpw",map);
    }

    @Override
    public void changePw(HashMap<String, Object> map) {
        sqlSession.update("User.changePw",map);
    }

    @Override
    public List<UserVo> getUserList() {
        List<UserVo> userVoList = sqlSession.selectList("User.getUserList");
        return userVoList;
    }

    @Override
    public UserVo authorityCheck(String u_id) {
        UserVo user = sqlSession.selectOne("User.authorityCheck", u_id);
        return user;
    }

    @Override
    public List<UserVo> getSUserList(HashMap<String, Object> map) {
        return sqlSession.selectList("User.getSUserList",map);
    }

    @Override
    public int getUserCount(HashMap<String, Object> map) {
        return sqlSession.selectOne("User.count",map);
    }
}
