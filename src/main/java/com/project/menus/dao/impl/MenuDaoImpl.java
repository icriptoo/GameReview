package com.project.menus.dao.impl;

import com.project.menus.vo.MenuVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.menus.dao.MenuDao;



import java.util.List;

@Repository("menudao")
public class MenuDaoImpl implements MenuDao {

    @Autowired
    SqlSession sqlSession;

    public List<MenuVo> getMenuList() {
        List<MenuVo> menulist = sqlSession.selectList("Menus.MenuList");
        return menulist;
    }
}
