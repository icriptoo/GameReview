package com.project.pds.customer.board.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface CtmService {
    void writePicture(HashMap<String, Object> map, HttpServletRequest request);

    String getSFileName(int board_number);
}
