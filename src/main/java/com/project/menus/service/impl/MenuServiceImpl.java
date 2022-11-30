package com.project.menus.service.impl;

import com.project.menus.dao.MenuDao;
import com.project.menus.service.MenuService;
import com.project.menus.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    public List<MenuVo> getMenuList() {

        List<MenuVo> menulist = menuDao.getMenuList();
        return menulist;
    }
}
