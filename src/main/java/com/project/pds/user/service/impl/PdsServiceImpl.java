package com.project.pds.user.service.impl;

import com.project.pds.user.dao.PdsDao;
import com.project.pds.user.service.PdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service("PdsService")
public class PdsServiceImpl implements PdsService {
    @Autowired
    private PdsDao pdsDao;


    @Override
    public void setWrite(HashMap<String, Object> map, HttpServletRequest request, HttpSession httpSession) {

        PdsFile.save(map, request, httpSession);

        this.pdsDao.setWrite(map);

    }

    @Override
    public Object getUserProfile(Object login) {
        Object getUserProfile = this.pdsDao.getUserProfile(login);
        return getUserProfile;
    }
}
