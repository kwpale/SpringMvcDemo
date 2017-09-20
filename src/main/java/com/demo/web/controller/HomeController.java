package com.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Home controller
 *
 * @version Revision History
 * <pre>
 * Author   Version     Date            Changes
 * pankplee  1.0         9/20/2017         Created
 * </pre>
 * @since 1.0
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(value = "/{id:\\d*}", method = RequestMethod.GET)
    @ResponseBody
    public String show(@PathVariable Long id, Model model) {
        return id.toString();
    }
}
