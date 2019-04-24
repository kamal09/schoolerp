package com.kamal.schoolerp.schoolerp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kamal.hossain1542 on 3/7/2019.
 */

@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        try {
            return "/view/home/home";
        } catch (Exception ex) {
            LOGGER.debug(ex.toString());
        }
        return "/view/home/home";
    }
}
