package com.ww.controller.power;

import com.ww.model.Menu;
import com.ww.model.Role;
import com.ww.model.Rolemenu;
import com.ww.model.RolemenuId;
import com.ww.service.MenuService;
import com.ww.service.power.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/2 0002.
 */
@Controller
@RequestMapping("power/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("power/role/index");
        List<Role> roles = roleService.getRoles(session);
        view.addObject("roles", roles);
        return view;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("power/role/add");
        view.addObject("pmenus",session.getAttribute("pmenus"));
        view.addObject("cmenus",session.getAttribute("cmenus"));
        return view;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(Role role,Integer[] menuname) {
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/power/role/index");
        //插入后返回主键值
        roleService.addRole(role);
        roleService.insertIntoRoleMenu(role.getRoleid(),menuname);
        return view;
    }

    @RequestMapping(value = "/{roleid}/edit", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable int roleid, HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("power/role/edit");
        view.addObject("editRole", roleService.getRoleById(roleid));
        //从session中取出目录
        view.addObject("pmenus",session.getAttribute("pmenus"));
        view.addObject("cmenus",session.getAttribute("cmenus"));
        return view;
    }

    /**
     * 更新角色时候同时更新角色权限
     * @param role
     * @param menuname
     * @return
     */
    @RequestMapping(value = "/{roleid}/update", method = RequestMethod.POST)
    public String update(Role role, Integer[] menuname) {
        roleService.updateRoleById(role);
        roleService.updateRoleMenu(role.getRoleid(), menuname);
        return "redirect:/power/role/index";
    }

    @RequestMapping(value = "/{roleid}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int roleid) {
        roleService.deleteRoleById(roleid);
        roleService.deleteRoleMenuByRoleId(roleid);
        return "redirect:/power/role/index";
    }
}
