package com.pragmaticbitbucket.spring5tutorial.controllers;

import com.pragmaticbitbucket.spring5tutorial.commands.UserCommand;
import com.pragmaticbitbucket.spring5tutorial.services.UserService;
import com.pragmaticbitbucket.spring5tutorial.utils.MyUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/* since i have registered my view with the WebMvcConfigurer, this controller is not needed*/
@Controller
public class SignupController {

    private UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("userCommand", new UserCommand());
        return "signup";
    }
/*
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignup(
            @RequestParam String email,
            @RequestParam String name,
            @RequestParam String password
    ) {
        return "redirect:/"; // to home page
    }
*/
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String   doSignup(@Validated UserCommand user,
                           BindingResult result,
                           RedirectAttributes redirectAttributes) {
        if (result.hasErrors())
            return "signup";

        userService.signup(user);
        MyUtils.flash(redirectAttributes, "success", "signupSuccess");

        return "redirect:/"; // to home page
    }
}