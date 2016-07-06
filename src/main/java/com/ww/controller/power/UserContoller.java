package com.ww.controller.power;

import com.ww.model.User;
import com.ww.service.power.RoleService;
import com.ww.service.power.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(String username,String logincode) {

        ModelAndView view = new ModelAndView();
        view.setViewName("power/user/index");

        view.addObject("users", userService.getUsers(username,logincode));
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

}
