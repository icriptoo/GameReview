package com.project.pds.customer.board.service.impl;

import com.project.pds.customer.board.dao.CtmDao;
import com.project.pds.customer.board.service.CtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Service
public class CtmServiceImpl implements CtmService {
    @Autowired
    private CtmDao ctmDao;
    @Override
    public void writePicture(HashMap<String, Object> map, HttpServletRequest request) {

        CtmFile.save(map, request);
        this.ctmDao.writePicture(map);

    }

    @Override
    public String getSFileName(int board_number) {
        String sFileName = this.ctmDao.getSFileName(board_number);
        return sFileName;
    }
}
