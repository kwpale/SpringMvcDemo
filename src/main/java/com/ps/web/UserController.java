package com.ps.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping("/users")
public class UserController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @RequestMapping(value = "/{id:\\d*}", method = RequestMethod.GET)
    @ResponseBody
    public String show(@PathVariable Long id, Model model) {
        return Arrays.asList(applicationContext.getBeanDefinitionNames()).toString();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
