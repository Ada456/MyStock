package com.ww.service;

import com.alibaba.druid.sql.visitor.functions.If;
import com.ww.dao.MenuMapper;
import com.ww.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/2 0002.
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public  Map<String, List<Menu>> selecAlltMenu() {

        List<Menu> menuList =  menuMapper.selectAll();
        List<Menu> pMenus = new ArrayList<>();
        List<Menu> cMenus = new ArrayList<>();

        Map<String, List<Menu>> map = new HashMap<>();

        for (Menu menu : menuList) {
            if (menu.getPid() == 0) {
                pMenus.add(menu);
            } else if (menu.getPid() != 0) {
                cMenus.add(menu);
            }
        }
        map.put("pMenus",pMenus);
        map.put("cMenus",cMenus);

        return map;
    }

}
