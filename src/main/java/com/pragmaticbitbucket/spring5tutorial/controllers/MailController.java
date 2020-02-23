package com.pragmaticbitbucket.spring5tutorial.controllers;

import com.pragmaticbitbucket.spring5tutorial.mail.MailSender;
import com.pragmaticbitbucket.spring5tutorial.mail.MockMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private MailSender mailSender;

    @Autowired
    // the name of the input param must be equal to the name of the bean
    // or based on profiles, the DI needs to be instantiated
    public MailController(MailSender m) {
        this.mailSender = m;
    }

    @RequestMapping("/mail")
    public String mail() {
        mailSender.send("mail@example.com", "Welcome!", "body details");
        return "mail sent";
    }
}

