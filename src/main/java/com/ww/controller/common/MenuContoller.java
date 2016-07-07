package com.ww.controller.common;

import com.ww.model.Menu;
import com.ww.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/2 0002.
 */
@Controller
public class MenuContoller {

    @Autowired
    MenuService menuService;

    @RequestMapping("index")
    public ModelAndView showMenu(HttpSession session){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");

        Map<String, List<Menu>> map = menuService.selecAlltMenu();

        view.addObject("pmenus",map.get("pMenus"));
        view.addObject("cmenus",map.get("cMenus"));

        session.setAttribute("cmenus",map.get("cMenus"));
        session.setAttribute("pmenus",map.get("pMenus"));
        return view;
    }
}
