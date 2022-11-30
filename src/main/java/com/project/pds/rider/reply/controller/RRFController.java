package com.project.pds.rider.reply.controller;

import com.project.pds.rider.reply.service.RRFPdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class RRFController {
    @Autowired
    private RRFPdsService rrfPdsService;

    @RequestMapping("Board/RRF/RRFUF")
    public String RRFUF(){
        return "riderboard/riderReplyFileUpdate";
    }

    @RequestMapping("Board/RRF/RRFU")
    public String RRFU(@RequestParam HashMap<String, Object> map,
                       HttpServletRequest request){
        this.rrfPdsService.setWrite(map, request);
        return "redirect:/Board/riderDetail?board_number=" + map.get("board_number") + "&menu_id=" + map.get("menu_id") + "&pageNum=1&contentNum=10";
    }

    @RequestMapping("/RiderWatch")
    @ResponseBody
    public String RiderWatch(@RequestParam HashMap<String, Object> map){
        String sFileName = this.rrfPdsService.getSFileName(map);
        return sFileName;
    }

}
