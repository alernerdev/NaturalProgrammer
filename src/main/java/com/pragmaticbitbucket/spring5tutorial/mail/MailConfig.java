package com.pragmaticbitbucket.spring5tutorial.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
if the beans you want to inject are not components and you dont have the source
code to modify it
* */
@Configuration
public class MailConfig {
    @Bean
    public DemoBean demoBean() {
        return new DemoBean();
    }

    @Bean
    @ConditionalOnProperty(name = "spring.mail.host", havingValue = "foo", matchIfMissing = true)
    //@Profile("dev")
    // where mockMailSender is the Bean name
    public MailSender mockMailSender() {
        return new MockMailSender();
    }

    @Bean
    @ConditionalOnProperty("spring.mail.host")
    //@Profile("!dev")
    // where smtpMailSender is the Bean name
    public MailSender smtpMailSender() {

        // this does NOT create a second bean.  The results of that method
        // are cached
        demoBean();

        return new SmtpMailSender();
    }
}
