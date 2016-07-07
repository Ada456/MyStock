package com.ww.controller.power;

import com.sun.deploy.net.HttpResponse;
import com.sun.net.httpserver.Authenticator;
import com.ww.entity.Page;
import com.ww.model.User;
import com.ww.service.power.RoleService;
import com.ww.service.power.UserService;
import com.ww.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/7/2 0002.
 */
@Controller
@RequestMapping("power/user")
public class UserContoller {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/index")
    public ModelAndView index(String username,String logincode,String currentPage) {

        ModelAndView view = new ModelAndView();
        view.setViewName("power/user/index");
        Page page = PageUtil.getPage(currentPage);

        view.addObject("users",userService.getUsersByPage(username, logincode, page));
        view.addObject("page", page);
        return view;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("power/user/add");
        view.addObject("roles",roleService.getRoles(session));
        return view;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user) {
        userService.addUser(user);
        return "redirect:/power/user/index";
    }


    @RequestMapping(value = "/{userid}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int userid, HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("power/user/edit");
        view.addObject("editUser", userService.getUserById(userid));
        return view;
    }

    @RequestMapping(value = "/{userid}/update",method = RequestMethod.POST)
    public String update(User user){
        userService.updateUserById(user);
        return "redirect:/power/user/index";
    }

    @RequestMapping(value = "/{userid}/delete",method = RequestMethod.GET)
    public String delete(@PathVariable int userid){
        userService.deleteUserById(userid);
        return "redirect:/power/user/index";
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ModelAndView getPageByAjax(String currentPage) {
        ModelAndView view = new ModelAndView();
        Page page = PageUtil.getPage(currentPage);

        view.addObject("users",userService.getUsersByPage(null, null, page));
        view.addObject("page", page);

        view.setViewName("power/table");
        return view;
    }


}
