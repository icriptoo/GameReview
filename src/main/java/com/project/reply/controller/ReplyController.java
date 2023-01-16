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
        replyVo = replyService.replySelect(map);
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

        replyService.replyDelete(map);

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
}
