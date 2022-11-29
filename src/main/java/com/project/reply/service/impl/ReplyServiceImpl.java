package com.project.reply.service.impl;

import com.project.board.vo.ReplyPager;
import com.project.reply.dao.ReplyDao;
import com.project.reply.service.ReplyService;
import com.project.reply.vo.CReplyVo;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyDao replyDao;

    public List<ReplyPager> getReplylist(HashMap<String, Object> map) {
        List<ReplyPager> readReply = replyDao.getReplylist(map);
        return readReply;
    }

    @Override
    public List<ReplyPager> getRReplyList(HashMap<String, Object> map) {
        List<ReplyPager> replyList = replyDao.getRReplyList(map);
        return replyList;
    }

    @Override
    public List<RiderReplyVo> getRiderReplylist(int board_number) {
        List<RiderReplyVo> readReply = replyDao.getRiderReplylist(board_number);
        return readReply;
    }

    @Override
    public void writeReply(ReplyVo replyVo) {
        replyDao.writeReply(replyVo);
    }

    @Override
    public void RiderwriteReply(RiderReplyVo riderReplyVo) {
        replyDao.RiderwriteReply(riderReplyVo);
    }

    @Override
    public void UpdateReply(HashMap<String, Object> map) {
        replyDao.UpdateReply(map);
    }

    @Override
    public void UpdateR_Reply(HashMap<String, Object> map) {
        replyDao.UpdateR_Reply(map);
    }

    @Override
    public int replyCount(HashMap<String, Object> map) { return replyDao.ReplyCount(map); }

    @Override
    public List<ReplyVo> replyList(HashMap<String, Object> map) {
        return replyDao.ReplyList(map);
    }

    @Override
    public int CReplyCount(int board_number) {
        return replyDao.CReplyCount(board_number);
    }

    @Override
    public int RReplyCount(int board_number) { return replyDao.RReplyCount(board_number); }

    @Override
    public void updateREndPage(HashMap<String, Object> map) { replyDao.updateREndPage(map); }

    @Override
    public void updateEndPage(HashMap<String, Object> map) {
        replyDao.updateEndpage(map);
    }

    @Override
    public List<ReplyVo> myReplyPage(String nickname) {
        List<ReplyVo>  myReplyPage = replyDao.myReplyPage(nickname);
        return myReplyPage;
    }

    @Override
    public List<CReplyVo> CreplyPage(String nickname) {
        List<CReplyVo> Creplypage = replyDao.Creplypage(nickname);
        return Creplypage;
    }

    @Override
    public List<CReplyVo> Rreplypage(String nickname) {
        List<CReplyVo> Rreplypage = replyDao.Rreplypage(nickname);
        return Rreplypage;
    }


    @Override
    public void DUpdateEndPage(HashMap<String, Object> map) {
        replyDao.DUpdateEndPage(map);
    }

    @Override
    public void DeleteReply(HashMap<String, Object> map) {
        replyDao.DeleteReply(map);
    }

    @Override
    public void DeleteR_Reply(int reply_number) {
        replyDao.DeleteR_Reply(reply_number);
    }
}
