package com.pragmaticbitbucket.spring5tutorial.services;

import com.pragmaticbitbucket.spring5tutorial.commands.UserCommand;
import com.pragmaticbitbucket.spring5tutorial.domain.User;
import com.pragmaticbitbucket.spring5tutorial.repositories.UserRepository;
import org.apache.commons.logging.LogFactory;
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

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // this runs after all the injections are done and service is created
    @PostConstruct
    public void init() {
        log.info("--- PostConstruct init has run -- ");
    }

    @EventListener
    public void afterApplicationReady(ApplicationReadyEvent e) {
        log.info("--- Application is ready to run -- ");
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
