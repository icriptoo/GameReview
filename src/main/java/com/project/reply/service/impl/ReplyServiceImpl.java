package com.project.reply.service.impl;

import com.project.reply.dao.ReplyDao;
import com.project.reply.service.ReplyService;
import com.project.reply.vo.ReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyDao replyDao;

    @Override
    public void replyWrite(HashMap<String, Object> map) {
        replyDao.replyWrite(map);
    }

    @Override
    public List<ReplyVo> replySelect(HashMap<String, Object> map) {
        List<ReplyVo> replyVo = replyDao.replySelect(map);
        return replyVo;
    }

    @Override
    public int replyCount(HashMap<String, Object> map) {
        return replyDao.replyCount(map);
    }

    @Override
    public void replyDelete(HashMap<String, Object> map) {
        replyDao.replyDelete(map);
    }

    @Override
    public void replyUpdate(HashMap<String, Object> map) {
        replyDao.replyUpdate(map);
    }

    @Override
    public void commentInsert(HashMap<String, Object> map) {
        replyDao.commentInsert(map);
    }

    @Override
    public int replyCSelect(HashMap<String, Object> map) {
        return replyDao.replyCSelect(map);
    }

    @Override
    public void replyDUpdate(HashMap<String, Object> map) {
        replyDao.replyDUpdate(map);
    }


}
