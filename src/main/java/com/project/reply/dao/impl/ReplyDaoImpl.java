package com.project.reply.dao.impl;

import com.project.reply.dao.ReplyDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDaoImpl implements ReplyDao {

    @Autowired
    SqlSession sqlSession;

}
