package com.project.pds.customer.board.controller;

import com.project.pds.customer.board.service.CtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
@Controller
public class CtmController {

    @Autowired
    private CtmService ctmService;


    @RequestMapping("/Board/writePicture")
    public String writePicture(@RequestParam HashMap<String, Object> map,
                               HttpServletRequest request) {
        this.ctmService.writePicture(map, request);

        return "redirect:/Board/CustomerDetail?board_number=" + map.get("customer_board_number") + "&menu_id=MENU_01&pageNum=1&contentNum=10&board_check=1";
    }

    public String getSFileName(int board_number) {
        String sFileName = this.ctmService.getSFileName(board_number);
        return sFileName;
    }
}
