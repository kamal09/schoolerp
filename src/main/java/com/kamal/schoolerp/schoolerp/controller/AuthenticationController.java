package com.kamal.schoolerp.schoolerp.controller;

import com.kamal.schoolerp.schoolerp.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/login/login"); // resources/template/view/login/login.html
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
         User user = new User();
         modelAndView.addObject("user", user);
        modelAndView.setViewName("view/login/register"); // resources/template/view/login/register.html
        return modelAndView;
    }
}
