package com.project.reply.dao.impl;

import com.project.reply.dao.ReplyDao;
import com.project.reply.vo.ReplyVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("replyDao")
public class ReplyDaoImpl implements ReplyDao {

    @Autowired
    SqlSession sqlSession;

    @Override
    public void replyWrite(HashMap<String, Object> map) {
        sqlSession.insert("Reply.replyWrite",map);
    }

    @Override
    public List<ReplyVo> replySelect(HashMap<String, Object> map) {
        List<ReplyVo> replyVo = sqlSession.selectList("Reply.replySelect",map);
        return replyVo;
    }

    @Override
    public int replyCount(HashMap<String, Object> map) {
        return sqlSession.selectOne("Reply.replyCount",map);
    }

    @Override
    public void replyDelete(HashMap<String, Object> map) {
        sqlSession.delete("Reply.replyDelete",map);
    }

    @Override
    public void replyUpdate(HashMap<String, Object> map) {
        sqlSession.update("Reply.replyUpdate",map);
    }

    @Override
    public void commentInsert(HashMap<String, Object> map) {
        sqlSession.insert("Reply.commentInsert",map);
    }


}
