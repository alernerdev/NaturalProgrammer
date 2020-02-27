package com.pragmaticbitbucket.spring5tutorial.controllers;

import com.pragmaticbitbucket.spring5tutorial.utils.MyUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/* since i have registered my view with the WebMvcConfigurer, this controller is not needed*/
@Controller
public class SignupController {

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignup(
            @RequestParam String email,
            @RequestParam String name,
            @RequestParam String password
    ) {
        return "redirect:/"; // to home page
    }

}