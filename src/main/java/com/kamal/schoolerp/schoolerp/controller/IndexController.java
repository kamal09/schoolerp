package com.kamal.schoolerp.schoolerp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kamal.hossain1542 on 3/7/2019.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "/view/home/index";
    }
}
