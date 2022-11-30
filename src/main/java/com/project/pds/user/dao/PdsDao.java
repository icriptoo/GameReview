package com.project.pds.user.dao;

import java.util.HashMap;

public interface PdsDao {
    void setWrite(HashMap<String, Object> map);

    Object getUserProfile(Object login);
}
