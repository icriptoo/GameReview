package com.project.reply.dao.impl;

import com.project.board.vo.ReplyPager;
import com.project.reply.dao.ReplyDao;
import com.project.reply.vo.CReplyVo;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ReplyDaoImpl implements ReplyDao {

    @Autowired
    SqlSession sqlSession;

    public List<ReplyPager> getReplylist(HashMap<String, Object> map){
        List<ReplyPager> readReply = sqlSession.selectList("Reply.Replylist", map);

        return readReply;
    }

    @Override
    public List<ReplyPager> getRReplyList(HashMap<String, Object> map) {
        List<ReplyPager> replyList = sqlSession.selectList("Reply.RReplyList",map);
        return replyList;
    }

    @Override
    public void updateREndPage(HashMap<String, Object> map) { sqlSession.update("Reply.UpdateREndPage",map); }

    @Override
    public void updateEndpage(HashMap<String, Object> map) {
        sqlSession.update("Reply.UpdateEndPage",map);
    }

    @Override
    public void DUpdateEndPage(HashMap<String, Object> map) {
        sqlSession.update("Reply.DUpdateEndPage", map);
    }

    @Override
    public int RReplyCount(int board_number) { return sqlSession.selectOne("Reply.RReplyCount",board_number); }

    @Override
    public int CReplyCount(int board_number) { return sqlSession.selectOne("Reply.CReplyCount",board_number); }

    @Override
    public List<ReplyVo> myReplyPage(String nickname) {
        List<ReplyVo>  myReplyPage = sqlSession.selectList("Reply.myReplyPage", nickname);
        return myReplyPage;
    }

    @Override
    public List<CReplyVo> Creplypage(String nickname) {
        List<CReplyVo> Creplypage = sqlSession.selectList("Reply.Creplypage", nickname);
        return Creplypage;
    }

    @Override
    public List<CReplyVo> Rreplypage(String nickname) {
        List<CReplyVo> Rreplypage = sqlSession.selectList("Reply.RreplyPage", nickname);
        return Rreplypage;
    }

    @Override
    public List<RiderReplyVo> getRiderReplylist(int board_number) {
        List<RiderReplyVo> readReply = sqlSession.selectList("Reply.RiderReplylist", board_number);

        return readReply;
    }

    @Override
    public void writeReply(ReplyVo replyVo) {
        sqlSession.insert("Reply.WriteReply", replyVo);
    }

    @Override
    public void RiderwriteReply(RiderReplyVo riderReplyVo) {
        sqlSession.insert("Reply.RiderReply",riderReplyVo);
    }

    @Override
    public void UpdateReply(HashMap<String, Object> map) {
        sqlSession.update("Reply.UpdateReply", map);
    }

    @Override
    public void UpdateR_Reply(HashMap<String, Object> map) {
        sqlSession.update("Reply.UpdateR_Reply",map);
    }

    @Override
    public int ReplyCount(HashMap<String, Object> map) {
        return sqlSession.selectOne("Reply.ReplyCount",map);
    }

    @Override
    public List<ReplyVo> ReplyList(HashMap<String, Object> map) {
        return sqlSession.selectList("Reply.ReplyPager",map);
    }

    @Override
    public void DeleteReply(HashMap<String, Object> map) {
        sqlSession.delete("Reply.DeleteReply", map);
    }

    @Override
    public void DeleteR_Reply(int reply_number) {
        sqlSession.delete("Reply.DeleteR_Reply", reply_number);
    }
}
