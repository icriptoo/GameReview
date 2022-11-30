package com.project.pds.user.dao.impl;

import com.project.pds.user.dao.PdsDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository("PdsDao")
public class PdsDaoImpl implements PdsDao {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public void setWrite(HashMap<String, Object> map) {
        String Check = this.sqlSession.selectOne("UserFile.getUserProfile", map);

        if (Check != null){
            this.sqlSession.update("UserFile.updateUserProfile",map);
        } else {
            this.sqlSession.insert("UserFile.insertUserProfile", map);
        }


    }

    @Override
    public Object getUserProfile(Object login) {
        Object getUserProfile = this.sqlSession.selectOne("UserFile.getProfile", login);
        return getUserProfile;
    }
}
