package com.kamal.schoolerp.schoolerp.controller;

import com.kamal.schoolerp.schoolerp.entities.User;
import com.kamal.schoolerp.schoolerp.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/login/login"); // resources/template/view/login/login.html
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("view/login/signup"); // resources/template/view/login/signup.html
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExist = userService.findUserByEmail(user.getEmail());

        if (userExist != null) {
            bindingResult.rejectValue("email", "error.user", "This Email already exists!");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("view/login/signup");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("msg", "User has been registered successfully!");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("view/login/signup");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/home/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(authentication.getName());

        modelAndView.addObject("userName", user.getFirstName() + " " + user.getLastName());
        modelAndView.setViewName("view/home/home");

        return modelAndView;
    }

    @RequestMapping(value = "/access_denied",method = RequestMethod.GET)
    public ModelAndView accessDenied(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/errors/access_denied");
        return modelAndView;
    }
}
