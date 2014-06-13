package com.its.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alexander
 */
@Controller
public class IndexController extends AppController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView view = new ModelAndView("index");
        view.addObject("title", appTitle);
        return view;
    }
}
