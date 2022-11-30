package com.project.pds.customer.board.dao.impl;

import com.project.pds.customer.board.dao.CtmDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CtmDaoImpl implements CtmDao {

    @Autowired
    private SqlSession sqlSession;
    @Override
    public void writePicture(HashMap<String, Object> map) {
        this.sqlSession.insert("File.writePicture", map);

    }

    @Override
    public String getSFileName(int board_number) {
        String sFileName = this.sqlSession.selectOne("File.getSFileNameC", board_number);
        return sFileName;
    }
}
