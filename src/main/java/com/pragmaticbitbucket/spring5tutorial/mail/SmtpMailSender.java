package com.pragmaticbitbucket.spring5tutorial.mail;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

//@Component
public class SmtpMailSender implements MailSender{

    private static Log log = LogFactory.getLog(MockMailSender.class);

    public SmtpMailSender() {

        log.info("SmtpMailSender created");
    }

    @Override
    public void send(String to, String subject, String body) {
        log.info("Sending SMTP mail to " + to);
        log.info("subject: " + subject);
    }
}
