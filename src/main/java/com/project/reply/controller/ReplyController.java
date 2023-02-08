package com.project.reply.controller;

import com.project.board.vo.BoardPager;
import com.project.reply.service.ReplyService;
import com.project.reply.vo.ReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class ReplyController {

    @Autowired
    ReplyService replyService;

    BoardPager boardPager = new BoardPager();


    // 댓글작성
    @RequestMapping(value = "/replywrite", produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String replyWrite(@RequestParam HashMap<String, Object> map){
        replyService.replyWrite(map);
        return "";
    }

    //댓글조회
    @RequestMapping("/replyselect")
    @ResponseBody
    public List<ReplyVo> replySelect(@RequestParam HashMap<String, Object> map){
        List<ReplyVo> replyVo = null;
        int PageNum = Integer.parseInt((String) map.get("pageNum"));
        boardPager.setPageNum(PageNum - 1);
        if(boardPager.getPageNum() != 0){
            boardPager.setPageNum((PageNum - 1) * 30 + 1);
        }
        map.put("pageNum",boardPager.getPageNum());
        map.put("c",1); // mapper구분자
        replyVo = replyService.replySelect(map);
        // 답글이 남아 있어 틀만 남아 있는 삭제된 댓글에 답글이 없을 경우 삭제된 댓글 완전히 삭제
        for (int i=0;i<replyVo.size();i++){
            if(replyVo.get(i).getD_ck() == 1){
                map.put("r_idx",replyVo.get(i).getR_idx());
                int j = replyService.replyCSelect(map);
                if(j == 0){
                    replyService.replyDelete(map);
                    replyVo = replyService.replySelect(map);
                }
            }
        }
        System.out.println();
        return replyVo;
    }

    //댓글페이징
    @RequestMapping("/replyP")
    @ResponseBody
    public HashMap<String, Object> replyP(@RequestParam HashMap<String, Object> map){
        int PageNum = Integer.parseInt((String) map.get("pageNum"));
        int ContentNum = Integer.parseInt((String) map.get("contentNum"));

        boardPager.setTotalCount(replyService.replyCount(map));
        boardPager.setPageNum(PageNum - 1);
        boardPager.setContentNum(ContentNum);
        boardPager.setCurrentBlock(PageNum);
        boardPager.setLastBlock();
        boardPager.prevNext(PageNum);
        boardPager.setStartPage();
        boardPager.setEndPage();
        if(boardPager.getPageNum() != 0){
            boardPager.setPageNum((PageNum - 1) * 30 + 1);
        }
        map.put("Pager",boardPager);
        return map;
    }

    // 댓글삭제
    @RequestMapping("/replyDelete")
    public String replyDelete(@RequestParam HashMap<String, Object>map, Model model){
        String b_idx = (String) map.get("b_idx");
        String menu_id = (String) map.get("menu_id");

        // 삭제 할려는 댓글에 답글 달려 있으면 댓글 내용만 지우고 답글을 볼 수 있는 형태로 업데이트
        int c = replyService.replyCSelect(map);
        if(c == 0) {
            replyService.replyDelete(map);
        } else {
            replyService.replyDUpdate(map);
        }
        model.addAttribute("b_idx",b_idx);
        model.addAttribute("menu_id",menu_id);
        model.addAttribute("contentNum",30);
        model.addAttribute("pageNum",1);
        return "redirect:/View";
    }

    // 댓글수정
    @RequestMapping("/replyUpdate")
    @ResponseBody
    public String replyUpdate(@RequestParam HashMap<String, Object> map){
        replyService.replyUpdate(map);
        return "";
    }

    // 답글등록
    @RequestMapping("/commentInsert")
    @ResponseBody
    public String commentInsert(@RequestParam HashMap<String, Object> map){
        replyService.commentInsert(map);
        return "";
    }

    // 답글조회
    @RequestMapping("/commentList")
    @ResponseBody
    public List<ReplyVo> commentList(@RequestParam HashMap<String, Object> map){
        List<ReplyVo> replyVo = replyService.replySelect(map);
        return replyVo;
    }
}
