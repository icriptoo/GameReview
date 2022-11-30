package com.project.reply.dao;

import com.project.board.vo.ReplyPager;
import com.project.reply.vo.CReplyVo;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;

import java.util.HashMap;
import java.util.List;

public interface ReplyDao {


    List<ReplyPager> getReplylist(HashMap<String, Object> map);

    List<RiderReplyVo> getRiderReplylist(int rider_board_number);

    void writeReply(ReplyVo replyVo);

    void RiderwriteReply(RiderReplyVo riderReplyVo);

    void UpdateReply(HashMap<String, Object> map);

    void DeleteReply(HashMap<String, Object> map);

    void DeleteR_Reply(int reply_number);

    void UpdateR_Reply(HashMap<String, Object> map);

    int ReplyCount(HashMap<String, Object> map);

    List<ReplyVo> ReplyList(HashMap<String, Object> map);

    int CReplyCount(int board_number);

    void updateEndpage(HashMap<String, Object> map);

    void DUpdateEndPage(HashMap<String, Object> map);

    int RReplyCount(int board_number);

    List<ReplyPager> getRReplyList(HashMap<String, Object> map);

    void updateREndPage(HashMap<String, Object> map);

    List<ReplyVo> myReplyPage(String nickname);

    List<CReplyVo> Creplypage(String nickname);

    List<CReplyVo> Rreplypage(String nickname);
}
