package com.pragmaticbitbucket.spring5tutorial.controllers;

import com.pragmaticbitbucket.spring5tutorial.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/* since i have registered my view with the WebMvcConfigurer, this controller is not needed*/
@Controller
public class HelloController {

    @Value("${app.name}")
    private String appName;

    @RequestMapping("/hello")
    public String hello(Model model) {
        // model.addAttribute("name", "Alex");
        model.addAttribute("name",
                MyUtils.getMessage("name",
                        "piece of boo",
                        "PIECE of baa"
                ));

        // return "hello world " + appName;
        return "hello";
    }

    /* compilerArgs has been configured with -parameters
    so the uri parameter name is the same as the function arg
     */
    @RequestMapping("/hello/{id}")
    public String helloId(Model model,
                          @PathVariable int id,
                          @RequestParam(required=false) String name) {

        model.addAttribute("id", id);
        model.addAttribute("name", name);

        // return "hello world " + appName;
        return "hello-id";
    }

    /*
    @RequestMapping("/hello")
    public ModelAndView hello() {

        ModelAndView mav = new ModelAndView("hello"); // logical view name
        mav.addObject("name", "Alex");

        return mav;
    }*/
}
