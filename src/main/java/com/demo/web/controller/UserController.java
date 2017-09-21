package com.demo.web.controller;

import com.demo.base.UserType;
import com.demo.entity.User;
import com.demo.repo.UserRepo;
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
public class UserController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping(value = "/{id:\\d*}", method = RequestMethod.GET)
    @ResponseBody
    public String show(@PathVariable Long id, Model model) {
        User user = com.demo.util.RecordBuilder.buildUser("Hi.das@fwq.com");
        user.setPassword("123");
        user.setUserType(UserType.User);
        userRepo.save(user);
        return Arrays.asList(applicationContext.getBeanDefinitionNames()).toString() + "\n"
                + Arrays.asList(applicationContext.getParent().getBeanDefinitionNames()).toString();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
