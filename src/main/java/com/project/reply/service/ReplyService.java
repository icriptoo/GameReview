package com.project.reply.service;

import com.project.board.vo.ReplyPager;
import com.project.reply.vo.CReplyVo;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;

import java.util.HashMap;
import java.util.List;

public interface ReplyService {

    List<ReplyPager> getReplylist(HashMap<String, Object> map);

    List<RiderReplyVo> getRiderReplylist(int board_number);

    void writeReply(ReplyVo replyVo);

    void RiderwriteReply(RiderReplyVo riderReplyVo);

    void UpdateReply(HashMap<String, Object> map);

    void DeleteReply(HashMap<String, Object> map);

    void DeleteR_Reply(int reply_number);

    void UpdateR_Reply(HashMap<String, Object> map);

    int replyCount(HashMap<String, Object> map);

    List<ReplyVo> replyList(HashMap<String, Object> map);

    int CReplyCount(int board_number);

    void updateEndPage(HashMap<String, Object> map);

    void DUpdateEndPage(HashMap<String, Object> map);

    int RReplyCount(int board_number);

    List<ReplyPager> getRReplyList(HashMap<String, Object> map);

    void updateREndPage(HashMap<String, Object> map);

    List<ReplyVo> myReplyPage(String nickname);

    List<CReplyVo> CreplyPage(String nickname);

    List<CReplyVo> Rreplypage(String nickname);
}
