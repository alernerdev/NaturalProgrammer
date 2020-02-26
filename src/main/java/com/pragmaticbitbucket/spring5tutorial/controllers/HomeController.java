package com.pragmaticbitbucket.spring5tutorial.controllers;

import com.pragmaticbitbucket.spring5tutorial.mail.MockMailSender;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

// when using view technology, this should be Controller rather than MVC RestController

/* since i have registered my view with the WebMvcConfigurer, this controller is not needed*/

/*
@Controller
public class HomeController {
    private static Log log = LogFactory.getLog(HomeController.class);

    @RequestMapping("/")
    // @ResponseBody
    public String home() {
        // the rest of the path to this view is configured
        // in application.properties

        return "home";
    }
}

*/


