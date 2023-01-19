package com.project.reply.dao;

import com.project.reply.vo.ReplyVo;

import java.util.HashMap;
import java.util.List;

public interface ReplyDao {

    void replyWrite(HashMap<String, Object> map);

    List<ReplyVo> replySelect(HashMap<String, Object> map);

    int replyCount(HashMap<String, Object> map);

    void replyDelete(HashMap<String, Object> map);

    void replyUpdate(HashMap<String, Object> map);

    void commentInsert(HashMap<String, Object> map);
}
