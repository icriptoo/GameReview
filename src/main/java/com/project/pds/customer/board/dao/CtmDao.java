package com.project.pds.customer.board.dao;

import java.util.HashMap;

public interface CtmDao {
    void writePicture(HashMap<String, Object> map);

    String getSFileName(int board_number);
}
