package com.demo.web.controller;

import com.demo.base.UserType;
import com.demo.entity.User;
import com.demo.repo.UserRepo;
import com.demo.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * User Controller
 *
 * @version Revision History
 * <pre>
 * Author   Version     Date            Changes
 * pankplee  1.0         9/20/2017         Created
 * </pre>
 * @since 1.0
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private UserRepo userRepo;
    private UserService userService;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/create/{id:\\d*}", method = RequestMethod.GET)
    @ResponseBody
    public String create(@PathVariable Long id) {
        User user = userService.create("Lee."+ id+"@demo.com", "demo", UserType.User);
        return user.toString();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String show() {
        List<User> user = userService.findAll();
        return user.toString();
    }
}
