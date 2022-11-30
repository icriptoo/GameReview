package com.project.pds.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public interface PdsService {
    void setWrite(HashMap<String, Object> map, HttpServletRequest request, HttpSession httpSession);

    Object getUserProfile(Object login);
}
