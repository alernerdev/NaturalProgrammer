package com.pragmaticbitbucket.spring5tutorial.services;

import com.pragmaticbitbucket.spring5tutorial.commands.UserCommand;
import com.pragmaticbitbucket.spring5tutorial.domain.User;
import com.pragmaticbitbucket.spring5tutorial.repositories.UserRepository;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;

@Service("UserService")
public class UserServiceImpl implements UserService {
    private static Log log = LogFactory.getLog(UserServiceImpl.class);

    @Value("${application.admin.email:admin@domainname.com}")
    private String adminEmail;
    @Value("${application.admin.password:password}")
    private String adminPassword;
    @Value("${application.admin.name:admin}")
    private String adminName;

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // this runs after all the injections are done and service is created
    @PostConstruct
    public void init() {
        log.info("--- PostConstruct init has run -- ");
    }

    @Override
    @EventListener
    @Transactional(propagation=Propagation.REQUIRED, readOnly = false)
    public void afterApplicationReady(ApplicationReadyEvent e) {
        log.info("--- Application is ready to run -- ");

        if (!userRepository.findByEmail("admin@example.com").isPresent()) {
            User user = new User();
            user.setEmail(adminEmail);
            user.setName(adminName);
            user.setPassword(adminPassword);
            user.getRoles().add(User.Role.ADMIN);

            userRepository.save(user);
        }
    }

    // transaction starts at the start of the function and ends at the end
    // if there is an exception in the middle, all changes get rolled back
    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    // create a new transaction or run within an existing transaction
    public void signup(UserCommand userCommand) {
        User user = userCommand.toUser();
        user.getRoles().add(User.Role.UNVERIFIED);
        userRepository.save(user);
    }
}
